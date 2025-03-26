package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.BackUpComDAO;
import com.server.productionserver.model.BackUpCom;
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
public class BackUpComApiController implements BackUpComApi{

    private final NativeWebRequest request;

    @Autowired
    BackUpComDAO backUpComDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public BackUpComApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<BackUpCom> findAllInfo() {
        List<BackUpCom> BackUpComList = backUpComDAO.findAll();
        return BackUpComList;
    }

    //根据id查询记录
    public Optional<BackUpCom> findInfoById(String Id) {
        Optional<BackUpCom> BackUpComList = backUpComDAO.findById(Id);
        return BackUpComList;
    }

    //插入记录
    public BackUpCom insertInfo(BackUpCom backupcom) {
        //先查询记录
        Optional<BackUpCom> BackUpComList = backUpComDAO.findById(backupcom.getid());
        //不存在则插入
        if(BackUpComList.isEmpty()) {
            BackUpCom newBackUpCom = new BackUpCom();
            newBackUpCom.setid(backupcom.getid());
            newBackUpCom.setlength(backupcom.getlength());
            newBackUpCom.setwidth(backupcom.getwidth());
            BackUpCom save = backUpComDAO.save(newBackUpCom);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String Id) {
        //先找
        Optional<BackUpCom> BackUpComList = backUpComDAO.findById(Id);
        //找不到
        if(BackUpComList.isEmpty()) return false;
        //找到了再删除
        backUpComDAO.deleteById(Id);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(BackUpCom backupcom) {
        //先查询记录
        Optional<BackUpCom> BackUpComList = backUpComDAO.findById(backupcom.getid());
        //不存在
        if(BackUpComList.isEmpty()) return false;
        else {
            BackUpCom newBackUpCom = new BackUpCom();
            newBackUpCom.setid(backupcom.getid());
            newBackUpCom.setlength(backupcom.getlength());
            newBackUpCom.setwidth(backupcom.getwidth());
            backUpComDAO.save(newBackUpCom);
            return true;
        }
    }

    /**
     * DELETE /reqDelSpareSpecs : 根据id删除信息
     *
     * @param boxId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除信息", nickname = "backUpIdDelete", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelSpareSpecs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> backUpIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String id) {
        String code;
        deleteFlag = deleteInfoById(id);
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
     * POST /reqGetSpareSpecs : 根据id获取信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取信息", nickname = "backUpIdGet", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetSpareSpecs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> backUpIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String id) {
        Optional<BackUpCom> backUpComs = findInfoById(id);
        String code = "200";

        if(backUpComs.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(backUpComs);
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
     * PUT /reqSetSpareSpecs : 根据id修改信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改信息", nickname = "backUpIdPut", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetSpareSpecs",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> backUpIdPut(@ApiParam(value = "", required=true) @RequestBody BackUpCom backupcom) {
        String code;
        changeFlag = changeInfoById(backupcom);
        if(changeFlag) {
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "通过id修改数据成功!";
                        exampleString += result;
                        exampleString += " \"}";
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
     * GET /reqGetAllSpareSpecs : 查询全部备品
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部备品", nickname = "backUpGet", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllSpareSpecs",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> backUpGet() {
        List<BackUpCom> backUpComs = findAllInfo();
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(backUpComs);
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
     * POST /reqAddSpareSpecs : 插入箱信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入信息", nickname = "backUpPost", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddSpareSpecs",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> backUpPost(@ApiParam(value = "", required=true) @RequestBody BackUpCom backupcom) {
        String code;
        BackUpCom save = insertInfo(backupcom);
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
