package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ComponentDAO;
import com.server.productionserver.model.Component;
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

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ComponentApiController implements ComponentApi {

    private final NativeWebRequest request;

    @Autowired
    ComponentDAO componentDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public ComponentApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Component> findAllInfo() {
        List<Component> ComponentList = componentDAO.findAll();
        return ComponentList;
    }

    //根据id查询记录
    public Optional<Component> findInfoById(String Id) {
        Optional<Component> ComponentList = componentDAO.findById(Id);
        return ComponentList;
    }

    //插入记录
    public Component insertInfo(String comId, Integer comNum, Integer comCount, Integer comOrder, Integer comLength, Integer comWidth, String comType, Integer comSize, Integer weldingArea, Integer producingArea, Integer producingNum, Integer comKind, String boxId, String workId) {
        //先查询记录
        Optional<Component> ComponentList = componentDAO.findById(comId);
        //不存在则插入
        if(ComponentList.isEmpty()) {
            Component newComponent = new Component();
            newComponent.setComId(comId);
            newComponent.setComNum(comNum);
            newComponent.setComCount(comCount);
            newComponent.setComOrder(comOrder);
            newComponent.setComLength(comLength);
            newComponent.setComWidth(comWidth);
            newComponent.setComType(comType);
            newComponent.setComSize(comSize);
            newComponent.setWeldingArea(weldingArea);
            newComponent.setProducingArea(producingArea);
            newComponent.setProducingNum(producingNum);
            newComponent.setboxId(boxId);
            newComponent.setComKind(comKind);
//            newComponent.setComTime(comTime);
            newComponent.setWorkId(workId);
            Component save = componentDAO.save(newComponent);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String comId) {
        //先找
        Optional<Component> ComponentList = componentDAO.findById(comId);
        //找不到
        if(ComponentList.isEmpty()) return false;
        //找到了再删除
        componentDAO.deleteById(comId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(String comId, Integer comNum, Integer comCount, Integer comOrder, Integer comLength, Integer comWidth, String comType, Integer comSize, Integer weldingArea, Integer producingArea, Integer producingNum, Integer comKind, String boxId, String workId) {
        //先查询记录
        Optional<Component> ComponentList = componentDAO.findById(comId);
        //不存在
        if(ComponentList.isEmpty()) return false;
        else {
            Component newComponent = new Component();
            newComponent.setComId(comId);
            newComponent.setComNum(comNum);
            newComponent.setComCount(comCount);
            newComponent.setComOrder(comOrder);
            newComponent.setComLength(comLength);
            newComponent.setComWidth(comWidth);
            newComponent.setComType(comType);
            newComponent.setComSize(comSize);
            newComponent.setWeldingArea(weldingArea);
            newComponent.setProducingArea(producingArea);
            newComponent.setProducingNum(producingNum);
            newComponent.setboxId(boxId);
            newComponent.setComKind(comKind);
//            newComponent.setComTime(comTime);
            newComponent.setWorkId(workId);
            componentDAO.save(newComponent);
            return true;
        }
    }


    /**
     * DELETE /component/deleteById : 根据id删除零件信息
     *
     * @param comId  (required)
     * @return 成功 (status code 200)
     *         or 记录不存在 (status code 404)
     */
    @ApiOperation(value = "根据id删除零件信息", nickname = "componentComIdDelete", notes = "", response = Object.class, tags={ "零件表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "找不到记录", response = Object.class)})
    @RequestMapping(value = "/component/deleteById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> componentComIdDelete(@ApiParam(value = "", required=true) @RequestParam(value="com_id") String comId) {
        String code;
        deleteFlag = deleteInfoById(comId);
        if(deleteFlag) {//删除成功
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

            System.out.println("根据id删除记录成功！");
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            code = "404";
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
            System.out.println("根据id删除记录失败！记录不存在!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }


    /**
     * GET /component/getById : 根据id获取零件信息
     *
     * @param comId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取零件信息", nickname = "componentComIdGet", notes = "", response = Object.class, tags={ "零件表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/component/getById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> componentComIdGet(@ApiParam(value = "",required=true) @RequestParam("com_id") String comId) {
        Optional<Component> components = findInfoById(comId);
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    String objectJson = JSON.toJSONString(components);
                    exampleString += objectJson;
                    exampleString += " ]}";

                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("根据id查询记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * GET /component : 查询全部零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部零件信息", nickname = "componentGet", notes = "", response = Object.class, tags={ "零件表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/component",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> componentGet() {
        List<Component> components = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(components);
                    exampleString += objectJson;
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("查询所有记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * PUT /component : 修改零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改零件信息", nickname = "componentComIdPut", notes = "", response = Object.class, tags={ "零件表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/component",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> componentComIdPut(@ApiParam(value = "", required=true) @RequestParam(value="com_id", required=true)  String comId,@ApiParam(value = "") @RequestParam(value="com_num", required=false)  Integer comNum,@ApiParam(value = "") @RequestParam(value="com_count", required=false)  Integer comCount,@ApiParam(value = "") @RequestParam(value="com_order", required=false)  Integer comOrder,@ApiParam(value = "") @RequestParam(value="com_length", required=false)  Integer comLength,@ApiParam(value = "") @RequestParam(value="com_width", required=false)  Integer comWidth,@ApiParam(value = "") @RequestParam(value="com_type", required=false)  String comType,@ApiParam(value = "") @RequestParam(value="com_size", required=false)  Integer comSize,@ApiParam(value = "") @RequestParam(value="welding_area", required=false)  Integer weldingArea,@ApiParam(value = "") @RequestParam(value="producing_area", required=false)  Integer producingArea,@ApiParam(value = "") @RequestParam(value="producing_num", required=false)  Integer producingNum, @ApiParam(value = "") @RequestParam(value="com_kind", required=false)  Integer comKind, @ApiParam(value = "") @RequestParam(value="box_id", required=false)  String boxId, @ApiParam(value = "", required=true) @RequestParam(value="work_id", required=false)  String workId) {
        String code;

        changeFlag = changeInfoById(comId, comNum, comCount, comOrder, comLength, comWidth, comType, comSize, weldingArea, producingArea, producingNum, comKind, boxId, workId);
            if(changeFlag) {
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
            System.out.println("通过id修改数据成功！");
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            code = "404";
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
            System.out.println("修改失败！数据不存在！");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    //todos:post报错415

    /**
     * POST /component : 插入零件信息
     *
     * @param comId  (required)
     * @param comNum  (optional)
     * @param comCount  (optional)
     * @param comOrder  (optional)
     * @param comLength  (optional)
     * @param comWidth  (optional)
     * @param comType  (optional)
     * @param comSize  (optional)
     * @param weldingArea  (optional)
     * @param producingArea  (optional)
     * @param producingNum  (optional)
     * @param comKind  (optional)
     * @param boxId  (optional)
     * @return 成功 (status code 201)
     *         or 禁止访问 (status code 403)
     */
    @ApiOperation(value = "插入零件信息", nickname = "componentPost", notes = "", response = Object.class, tags={ "零件表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "禁止访问", response = Object.class),})
    @RequestMapping(value = "/component",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> componentPost(@ApiParam(value = "", required=true) @RequestParam(value="com_id", required=true)  String comId,@ApiParam(value = "") @RequestParam(value="com_num", required=false)  Integer comNum,@ApiParam(value = "") @RequestParam(value="com_count", required=false)  Integer comCount,@ApiParam(value = "") @RequestParam(value="com_order", required=false)  Integer comOrder,@ApiParam(value = "") @RequestParam(value="com_length", required=false)  Integer comLength,@ApiParam(value = "") @RequestParam(value="com_width", required=false)  Integer comWidth,@ApiParam(value = "") @RequestParam(value="com_type", required=false)  String comType,@ApiParam(value = "") @RequestParam(value="com_size", required=false)  Integer comSize,@ApiParam(value = "") @RequestParam(value="welding_area", required=false)  Integer weldingArea,@ApiParam(value = "") @RequestParam(value="producing_area", required=false)  Integer producingArea,@ApiParam(value = "") @RequestParam(value="producing_num", required=false)  Integer producingNum, @ApiParam(value = "") @RequestParam(value="com_kind", required=false)  Integer comKind, @ApiParam(value = "", required=true) @RequestParam(value="box_id", required=false)  String boxId, @ApiParam(value = "", required=true) @RequestParam(value="work_id", required=false)  String workId) {
        String code;
        Component save = insertInfo(comId, comNum, comCount, comOrder, comLength, comWidth, comType, comSize, weldingArea, producingArea, producingNum, comKind, boxId, workId);

        if(save == null) {//数据已存在
            insertFlag = false;
            code = "403";//禁止访问，数据已存在
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
            System.out.println("插入记录请求失败!记录已存在!");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        } else {//save成功
            insertFlag = true;
            code = "201";//创建数据成功
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
            System.out.println("插入记录请求成功!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }
}
