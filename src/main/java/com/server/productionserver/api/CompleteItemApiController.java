package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.CompleteItemDAO;
import com.server.productionserver.model.CompleteItem;
import com.server.productionserver.model.Item;
import com.server.productionserver.model.ProductNotice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.ibatis.jdbc.Null;
import org.simpleframework.xml.core.Complete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

//生产量零件表
@CrossOrigin(origins = "*")
@Controller
public class CompleteItemApiController implements CompleteItemApi{
    private final NativeWebRequest request;
    private boolean deleteFlag;

    @Autowired
    CompleteItemDAO completeItemDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public CompleteItemApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //插入记录
    public void insertInfo(CompleteItem itemList) {
        //覆盖插入
        CompleteItem newItem = new CompleteItem();
        newItem.setWorkNum(itemList.getWorkNum());
        newItem.setPlanDate(itemList.getPlanDate());
        newItem.setStaffName(itemList.getStaffName());
        newItem.setStaffJob(itemList.getStaffJob());
        newItem.setBox(itemList.getBox());
        newItem.setComOrder(itemList.getComOrder());
        newItem.setLength(itemList.getLength());
        newItem.setWidth(itemList.getWidth());
        newItem.setFullLength(itemList.getFullLength());
        newItem.setNum(itemList.getNum());
        newItem.setSpare(itemList.getSpare());
        newItem.setOrderArea(itemList.getOrderArea());
        newItem.setProductArea(itemList.getProductArea());
        newItem.setComplete(itemList.getComplete());
        newItem.setSheetType(itemList.getSheetType());
        CompleteItem save = completeItemDAO.save(newItem);
    }

    //条件查询
    public List<CompleteItem> findCertainInfo(String beginDate, String endDate, String staffName, String staffJob, String workNum) {
        List<CompleteItem> allList = completeItemDAO.findAll();
        List<CompleteItem> resultList = new ArrayList<>();

        // 定义日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        for(CompleteItem item : allList) {
            if(staffJob != null && !staffJob.isEmpty()) {
                if(!item.getStaffJob().equals(staffJob)) continue;
            }
            if(staffName != null && !staffName.isEmpty()) {
                if(!item.getStaffName().contains(staffName)) continue;
            }
            if(workNum != null && !workNum.isEmpty()) {
                if(!item.getWorkNum().contains(workNum)) continue;
            }
            if(beginDate != null && !beginDate.isEmpty()) {
                LocalDate beginTime = LocalDate.parse(beginDate, formatter);
                //如果item的PlanDate为空，直接跳过
                if(item.getPlanDate() == null || item.getPlanDate().isEmpty()) continue;
                LocalDate planTime = LocalDate.parse(item.getPlanDate(), formatter);
                if(planTime.isBefore(beginTime)) continue;
            }
            if(endDate != null && !endDate.isEmpty()) {
                LocalDate endTime = LocalDate.parse(endDate, formatter);
                //如果item的PlanDate为空，直接跳过
                if(item.getPlanDate() == null || item.getPlanDate().isEmpty()) continue;
                LocalDate planTime = LocalDate.parse(item.getPlanDate(), formatter);
                if(planTime.isAfter(endTime)) continue;
            }
            resultList.add(item);
        }
        return resultList;
    }

    /**
     * POST /output/get : 获取零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取完成零件信息", nickname = "completeItemGet", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/output/get",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> completeItemGet(@ApiParam(value = "", required=false) @RequestParam(value = "begin_date") String beginDate,
                                                  @ApiParam(value = "", required=false) @RequestParam(value = "end_date") String endDate,
                                                  @ApiParam(value = "", required=false) @RequestParam(value = "staff_name") String staffName,
                                                  @ApiParam(value = "", required=false) @RequestParam(value = "staff_job") String staffJob,
                                                  @ApiParam(value = "", required=false) @RequestParam(value = "work_num") String workNum) {
        List<CompleteItem> completeItems = findCertainInfo(beginDate, endDate, staffName, staffJob, workNum);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" :  ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(completeItems);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("查询满足条件记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST /output/enter : 插入零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入完成零件信息", nickname = "completeItemPost", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/enter",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> completeItemPost(@ApiParam(value = "", required=true) @RequestBody List<CompleteItem> itemList) {

        //先遍历传入数据根据条件对数据库进行删除
        for(CompleteItem item:itemList) {
            if(!item.getWorkNum().isEmpty()) {
                completeItemDAO.deleteByWorkNumAndStaffJob(item.getWorkNum(), item.getStaffJob(), item.getPlanDate());
            }
        }

        //然后所有传入的数据插入数据库
        for(CompleteItem item:itemList) {
            insertInfo(item);
        }

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+200+", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        System.out.println("插入记录请求成功!");
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    /**
     * DELETE /output/delete : 删除零件报表信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除零件信息", nickname = "completeItemDelete", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/delete",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> productNoticeDelete(@ApiParam(value = "", required=true) @RequestBody List<Long> idList) {
        String code;
        for(Long id: idList) {
            try {
                // 尝试删除记录
                completeItemDAO.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                // 处理记录不存在的情况
                System.out.println("记录不存在，id：" + id);
            }
        }
        code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });

        System.out.println("删除记录成功！");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
