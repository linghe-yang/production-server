package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.BoxDAO;
import com.server.productionserver.model.Box;
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
public class BoxApiController implements BoxApi {

    private final NativeWebRequest request;

    @Autowired
    BoxDAO boxDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public BoxApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Box> findAllInfo() {
        List<Box> BoxList = boxDAO.findAll();
        return BoxList;
    }

    //根据id查询记录
    public Optional<Box> findInfoById(String Id) {
        Optional<Box> BoxList = boxDAO.findById(Id);
        return BoxList;
    }

    //插入记录
    public Box insertInfo(Box box) {
        //先查询记录
        Optional<Box> BoxList = boxDAO.findById(box.getid());
        //不存在则插入
        if(BoxList.isEmpty()) {
            Box newBox = new Box();
            newBox.setid(box.getid());
            newBox.setBoxName(box.getBoxName());
            newBox.setcolor(box.getcolor());
            newBox.setWorkId(box.getworkId());
            Box save = boxDAO.save(newBox);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String boxId) {
        //先找
        Optional<Box> BoxList = boxDAO.findById(boxId);
        //找不到
        if(BoxList.isEmpty()) return false;
        //找到了再删除
        boxDAO.deleteById(boxId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(Box box) {
        //先查询记录
        Optional<Box> BoxList = boxDAO.findById(box.getid());
        //不存在
        if(BoxList.isEmpty()) return false;
        else {
            Box newBox = new Box();
            newBox.setid(box.getid());
            newBox.setBoxName(box.getBoxName());
            newBox.setcolor(box.getcolor());
            newBox.setWorkId(box.getworkId());
            boxDAO.save(newBox);
            return true;
        }
    }

    /**
     * DELETE /reqDelBox : 根据id删除箱信息
     *
     * @param boxId  (required)
     * @return 成功 (status code 200)
     *          or 记录不存在 (status code 404)
     */
    @Override
    @ApiOperation(value = "根据id删除箱信息", nickname = "boxBoxIdDelete", notes = "", response = Object.class, tags={ "箱表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelBox",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> boxBoxIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String boxId) {
        String code;
        deleteFlag = deleteInfoById(boxId);
        if(deleteFlag) {//删除成功
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "根据id删除记录成功!";
                        exampleString += result;
                        exampleString += " \"}";
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

                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "根据id删除记录失败！记录不存在!";
                        exampleString += result;
                        exampleString += " \"}";
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
     * POST /reqGetBox : 根据id获取箱信息
     *
     * @param boxId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取箱信息", nickname = "boxBoxIdGet", notes = "", response = Object.class, tags={ "箱表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetBox",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> boxBoxIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String boxId) {
        Optional<Box> boxs = findInfoById(boxId);
        String code = "200";

        if(boxs.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(boxs);
                        exampleString += objectJson;
                        exampleString += " ]}";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据id查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
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

            System.out.println("根据id查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }


    /**
     * PUT /reqSetBox: 根据id修改箱信息
     *
     * @param boxId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改箱信息", nickname = "boxBoxIdPut", notes = "", response = Object.class, tags={ "箱表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetBox",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> boxBoxIdPut(@ApiParam(value = "", required=true) @RequestBody Box box) {

        String code;
        changeFlag = changeInfoById(box);
        if(changeFlag) {
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
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

        } else {
            code = "404";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "修改失败！数据不存在!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("修改失败！数据不存在！");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    /**
     * GET /reqGetAllBox : 查询全部箱
     *
     * @return 成功 (status code 200)
     */
    @Override
    @ApiOperation(value = "查询全部箱", nickname = "boxGet", notes = "", response = Object.class, tags={ "箱表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllBox",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> boxGet() {

        List<Box> boxs = findAllInfo();
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(boxs);
                    exampleString += objectJson;
                    exampleString += "}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("查询所有记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * POST /reqAddBox : 插入箱信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入箱信息", nickname = "boxPost", notes = "", response = Object.class, tags={ "箱表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddBox",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> boxPost(@ApiParam(value = "", required=true) @RequestBody Box box) {
        String code;
        Box save = insertInfo(box);
        if(save == null) {//数据已存在 
            insertFlag = false;
            code = "403";//禁止访问，数据已存在
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "插入记录请求失败!记录已存在!";
                        exampleString += result;
                        exampleString += " \"}";
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
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "插入记录请求成功!";
                        exampleString += result;
                        exampleString += " \"}";
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
