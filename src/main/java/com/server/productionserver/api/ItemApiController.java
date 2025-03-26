package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ItemDAO;
import com.server.productionserver.DAO.LabelsDAO;
import com.server.productionserver.DAO.PackingDAO;
import com.server.productionserver.DTO.ItemDTO;
import com.server.productionserver.config.JdbcTemplateConfig;
import com.server.productionserver.model.*;
import com.server.productionserver.service.MonthWorkService;
import com.server.productionserver.service.RepeatedLabelsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ItemApiController implements ItemApi {
    private final NativeWebRequest request;

    @Autowired
    private MonthWorkService monthWorkService;

    @Autowired
    private RepeatedLabelsService repeatedLabelsService;

    private boolean deleteFlag;

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    PackingDAO packingDAO;

    @Autowired
    LabelsDAO labelsDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //条件查询
    public List<Item> findCertainInfo(Integer formType, String workNum) {
        List<Item> allList = itemDAO.findAll();
        if (formType == null || formType == 0){
            return allList.stream()
                    //如果workNum为空，则不进行筛选。如果workNum不为空，则筛选出workNum包含workNum的项
                    .filter(item -> workNum == null || workNum.isEmpty() || item.getWorkNum().contains(workNum))
                    .collect(Collectors.toList());
        }

        return allList.stream()
                //如果workNum为空，则不进行筛选。如果workNum不为空，则筛选出workNum包含workNum的项
                .filter(item -> workNum == null || workNum.isEmpty() || item.getWorkNum().contains(workNum))
                .filter(item -> formType == null || item.getFormType().equals(formType))
                .collect(Collectors.toList());
    }

    //获取去重箱号
    public List<String> findRemoveDuplicatesBoxMarks(Integer formType, String workNum) {
        List<Item> allList = itemDAO.findAll();
        List<Item> resultList = new ArrayList<>();

        for (Item item : allList) {
            if (workNum != null && !workNum.isEmpty()) {
                if (!item.getWorkNum().contains(workNum)) continue;
            }
            if (formType != null) {
                if (item.getFormType() != formType) continue;
            }
            resultList.add(item);
        }

        // 创建一个 Set 用于存放不重复的元素,根据Item的属性box进行去重，返回的结果是box的list
        Set<String> boxSet = new TreeSet<>();
        for (Item item : resultList) {
            boxSet.add(item.getBox());
        }

        return new ArrayList<>(boxSet);
    }

    //根据WorkNum和FormType删除零件
    public void deleteItemByWorkNumAndFormType(Item itemList) {
        List<Item> items = itemDAO.findByWorkNumAndFormType(itemList.getWorkNum(), itemList.getFormType());
        //遍历并删除匹配的零件记录
        for (Item item : items) {
            itemDAO.delete(item);
        }
    }


    //插入记录
    public void insertInfo(Item item) {
        //workNum、comOrder、formType理论上可以唯一决定一条记录
        List<Item> items = itemDAO.findByWorkNumAndComOrderAndFormType(item.getWorkNum(), item.getComOrder(), item.getFormType());

        //如果items为空，直接插入
        if (items.isEmpty()) {
            //complete<0时，不进行插入
            if (item.getComplete() < 0) return;
            //记录不存在，直接插入
            Item newItem = new Item();
            newItem.setComOrder(item.getComOrder());
            newItem.setType(item.getType());
            newItem.setLength(item.getLength());
            newItem.setWidth(item.getWidth());
            newItem.setNum(item.getNum());
            newItem.setCutLength(item.getCutLength());
            newItem.setCutWidth(item.getCutWidth());
            newItem.setCount(item.getCount());
            newItem.setSpare(item.getSpare());
            newItem.setFullLength(item.getFullLength());
            newItem.setOrderArea(item.getOrderArea());
            newItem.setProductArea(item.getProductArea());
            newItem.setHouseType(item.getHouseType());
            newItem.setPosition(item.getPosition());
            newItem.setBox(item.getBox());
            newItem.setWorkNum(item.getWorkNum());
            newItem.setFormType(item.getFormType());
            newItem.setComplete(item.getComplete());
            itemDAO.save(newItem);
        }
    }

    //packing插入
    public boolean insertPacking(List<Item> itemList) {
        if (itemList.isEmpty()) return false;

        //前端保证每次传来的WorkNum均为staticWorkNum
        String staticWorkNum = itemList.get(0).getWorkNum();

        //newList不为空：一定要先筛选FormType为2的项!然后再去重统计箱子种类数量
        //筛选结果输出到newList
        List<Item> newList = itemList.stream()
                .filter(item -> item.getFormType().equals(2))
                .collect(Collectors.toMap(Item::getBox, Function.identity(), (oldItem, newItem) -> oldItem))
                .values()
                .stream()
                .collect(Collectors.toList());

        int totalBoxNum = newList.size();

        //判断newList是否为空，如果为空，则直接返回
        if (newList.isEmpty()) return false;

        //生成newPackingList<packing>
        //元素只有workNum:String,totalBoxNum:Integer,thisBoxNum:Integer,box:String
        //计算总数，设置totalBoxNum,对应thisBoxNum从1自增,box、workNum从newList复制
        List<Packing> newPackingList = new ArrayList<>();
        int thisBoxNum = 0;
        for (Item item : newList) {
            thisBoxNum++;
            Packing packing = new Packing();
            packing.setWorkNum(item.getWorkNum());
            packing.setTotalBoxNum(totalBoxNum);
            packing.setThisBoxNum(thisBoxNum);
            packing.setBox(item.getBox());
            newPackingList.add(packing);
        }

        packingDAO.deleteByWorkNum(staticWorkNum);

        for (Packing packing : newPackingList) {
            Packing newPack = new Packing();
            newPack.setWorkNum(packing.getWorkNum());
            newPack.setTotalBoxNum(totalBoxNum);
            newPack.setThisBoxNum(packing.getThisBoxNum());
            newPack.setBox(packing.getBox());
            packingDAO.save(newPack);
        }
        return true;

    }

    //labels插入
    public boolean insertLabels(List<Item> itemList) {
        if (itemList.isEmpty()) return false;
        //前端保证每次传来的WorkNum均为staticWorkNum，为相同值
        String staticWorkNum = itemList.get(0).getWorkNum();

        //newList不为空：筛选FormType为2的项,筛选结果输出到newList
        List<Item> newList = itemList.stream()
                .filter(item -> item.getFormType().equals(2))
                .collect(Collectors.toList());
        //判断newList是否为空，如果为空，则直接返回
        if (newList.isEmpty()) return false;


        //labels表中若存在workNum与待插入相同，直接删除
        labelsDAO.deleteByWorkNum(staticWorkNum);

        //生成待插入的List<labels>，元素属性分别为
        //{work_num:string,type:string,length:string,width:string,position:string',box:string}
        //其中所有值均为从itemList中映射而来
        //newLabelsList中的元素需要根据num进行映射，例如num=2，需要插入两条相同的元素
        List<Labels> newLabelsList = new ArrayList<>();
        for (Item item : newList) {
            for (int i = 0; i < Integer.parseInt(item.getNum()); i++) {
                Labels label = new Labels();
                label.setWorkNum(item.getWorkNum());
                label.setType(item.getType());
                label.setLength(item.getLength());
                label.setWidth(item.getWidth());
                label.setPosition(item.getPosition());
                label.setBox(item.getBox());
                newLabelsList.add(label);
            }
        }

        //将newLabelsList中的元素进行排序
        //排序规则为：
        //1.按照length转换成的整数进行升序排序
        newLabelsList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getLength())));
        //2.根据box进行排序：如果box长度不一样，则按照box长度升序排序；如果box长度一样，按照字典序升序排序。
        newLabelsList.sort(Comparator
                .comparingInt((Labels o) -> o.getBox().length())
                .thenComparing(Labels::getBox)
        );


        //在newLabelsList的每两个不同的箱的元素之间插入一个特殊元素
        //特殊元素的type属性为前面元素的box的属性，其他属性均为空
        List<Labels> resultLabels = new ArrayList<>();
        for (int i = 0; i < newLabelsList.size(); i++) {
            resultLabels.add(newLabelsList.get(i));
            if (i + 1 < newLabelsList.size() && !newLabelsList.get(i).getBox().equals(newLabelsList.get(i + 1).getBox())) {
                Labels specialLabel = new Labels();
                specialLabel.setWorkNum(staticWorkNum);
                specialLabel.setType(newLabelsList.get(i).getBox());
                specialLabel.setLength("");
                specialLabel.setWidth("");
                specialLabel.setPosition("");
                specialLabel.setBox(newLabelsList.get(i).getBox());
                resultLabels.add(specialLabel);
            }
        }
        Labels specialLabel = new Labels();
        specialLabel.setWorkNum(staticWorkNum);
        specialLabel.setType(newLabelsList.get(newLabelsList.size() - 1).getBox());
        specialLabel.setLength("");
        specialLabel.setWidth("");
        specialLabel.setPosition("");
        specialLabel.setBox(newLabelsList.get(newLabelsList.size() - 1).getBox());
        resultLabels.add(specialLabel);

        //将resultLabels中的元素插入到labels表中
        for (Labels label : resultLabels) {
            Labels newLabel = new Labels();
            newLabel.setWorkNum(label.getWorkNum());
            newLabel.setType(label.getType());
            newLabel.setLength(label.getLength());
            newLabel.setWidth(label.getWidth());
            newLabel.setPosition(label.getPosition());
            newLabel.setBox(label.getBox());
            labelsDAO.save(newLabel);
        }
        return true;
    }

    //根据workNum删除items,packing和labels
    public void deleteItemAndPackingAndLabelsByWorkNum(String workNum) {
        itemDAO.deleteByWorkNum(workNum);
        packingDAO.deleteByWorkNum(workNum);
        labelsDAO.deleteByWorkNum(workNum);
    }

    //修改零件complete状态
    public void changeComplete(List<ItemDTO> itemDTOList) {
        for (ItemDTO itemDTO : itemDTOList) {
            String newWorkNum = itemDTO.getWorkNum();
            String newComOrder = itemDTO.getComOrder();
            Integer newComplete = itemDTO.getComplete();
            Integer newFormType = itemDTO.getFormType();
            String cmd = itemDTO.getCmd();

            //complete>=0时，才进行修改
            if (newComplete < 0) continue;

            if ("absolute".equals(cmd)) {
                //将数据库中的complete字段直接设置为api传来的值
                List<Item> items = itemDAO.findByWorkNumAndComOrderAndFormType(newWorkNum, newComOrder, newFormType);
                for (Item changeItem : items) {
                    //修改检索到的items的complete字段
                    changeItem.setComplete(newComplete);
                    //TODO:需要执行update操作
                    itemDAO.save(changeItem);
                }
            } else if ("relative".equals(cmd)) {
                //将数据库中的complete字段加上api传来的值
                List<Item> items = itemDAO.findByWorkNumAndComOrderAndFormType(newWorkNum, newComOrder, newFormType);
                for (Item changeItem : items) {
                    //修改检索到的items的complete字段
                    if (changeItem.getComplete() + newComplete < 0) {
                        changeItem.setComplete(0);
                    } else {
                        changeItem.setComplete(changeItem.getComplete() + newComplete);
                    }
                    //TODO:需要执行update操作
                    itemDAO.save(changeItem);
                }
            }

        }
    }


    /**
     * POST /reqStaffGetCpf : 获取零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取零件信息", nickname = "itemGet", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqStaffGetCpf",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> itemGet(@ApiParam(value = "", required = false) @RequestParam(value = "form_type") Integer formType, @ApiParam(value = "", required = false) @RequestParam(value = "work_num") String workNum) {
        List<Item> allList = findCertainInfo(formType, workNum);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \" " + code + " \", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(allList);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("数据查找成功!");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * POST /reqStaffPostCpf : 插入零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入零件报表信息", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqStaffPostCpf",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> itemPost(@ApiParam(value = "", required = true) @RequestBody List<Item> itemList) {

        for (Item item : itemList) {
//            deleteItemByWorkNumAndFormType(item);
            itemDAO.deleteByWorkNum(item.getWorkNum());
        }
        for (Item item : itemList) {
            insertInfo(item);
        }

        //对packing插入
        boolean packingInsertFlag = insertPacking(itemList);
        if (!packingInsertFlag) System.out.println("插入packing失败！");

        //对labels插入
        boolean labelInsertFlag = insertLabels(itemList);
        if (!labelInsertFlag) System.out.println("插入labels失败！");

        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : " + 200 + ", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        System.out.println("插入item记录请求成功!");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * DELETE /reqStaffDeleteCpf : 根据workNum删除零件报表信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除零件报表信息", nickname = "itemDelete", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqStaffDeleteCpf",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> itemDelete(@ApiParam(value = "", required = true) @RequestParam("work_num") String workNum) {
        String code;
        deleteItemAndPackingAndLabelsByWorkNum(workNum);
//        if(deleteFlag) {//删除成功
        code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : " + code + ", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });

        System.out.println("删除记录成功！");
        return new ResponseEntity<>(HttpStatus.OK);

//        } else {
//            code = "404";
//            getRequest().ifPresent(request -> {
//                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
//                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
//
//                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
//                        exampleString += " ]}";
//                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
//                        break;
//                    }
//                }
//
//            });
//            System.out.println("删除记录失败！记录不存在!");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    /**
     * POST /reqChangeItem : 修改零件状态
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改零件状态", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqChangeItem",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> itemChange(@ApiParam(value = "", required = true) @RequestBody List<ItemDTO> itemDTOList) {
        changeComplete(itemDTOList);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : " + code + ", \"result\" : \" ";
                    String result = "修改数据成功!";
                    exampleString += result;
                    exampleString += " \"}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        System.out.println("修改数据成功！");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * POST /getNoticeBoxMarks : 获取去重箱号
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取去重箱号", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/getNoticeBoxMarks",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> itemGetBoxMarks(@ApiParam(value = "", required = false) @RequestParam(value = "form_type") Integer formType, @ApiParam(value = "", required = false) @RequestParam(value = "work_num") String workNum) {
        List<String> allList = findRemoveDuplicatesBoxMarks(formType, workNum);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \" " + code + " \", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(allList);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("数据查找成功!");
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * GET /repeatLabels : 调用存储过程,把获取的数据重复set_num遍
     *
     * @param workNum 编号
     * @return 重复数据的 JSON 格式响应
     */
    @Override
    public ResponseEntity<Object> repeatLabels(@RequestParam("work_num") String workNum) {

        List<Labels> repeatedLabels = repeatedLabelsService.callRepeatedLabelsByWorkNum(workNum);

        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(repeatedLabels);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * GET /monthWork : 调用存储过程
     *
     * @param date 年月日期
     * @param name 姓名
     * @return 重复数据的 JSON 格式响应
     */
    @GetMapping("/monthWork")
    public ResponseEntity<Object> monthWork(@RequestParam("date") String date, @RequestParam("name") String name) {
        List<MonthWorkLogData> monthWork = monthWorkService.callMonthWork(date, name);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : " + 200 + ", \"data\" :  ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(monthWork);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
