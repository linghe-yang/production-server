package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.CurlDirectionDAO;
import com.server.productionserver.model.CurlDirection;
import com.server.productionserver.model.OrganizationRequirements;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class CurlDirectionApiController implements CurlDirectionApi {

    private final NativeWebRequest request;

    @Autowired
    CurlDirectionDAO curlDirectionDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public CurlDirectionApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    //查询全部记录
    public List<CurlDirection> findAllInfo() {
        List<CurlDirection> curlDirectionList = curlDirectionDAO.findAll();
        return curlDirectionList;
    }

    //根据id查询记录
    public List<CurlDirection> findInfoByIdAndNum(String cusId, String num) {
        List<CurlDirection> allList = curlDirectionDAO.findAll();
        List<CurlDirection> resultList = new ArrayList<>();

        for(CurlDirection curl : allList) {
            if(cusId != null && !cusId.isEmpty()) {
                if(!curl.getid().equals(cusId)) continue;
            }
            if(num != null && !num.isEmpty()) {
                if(!num.contains(curl.getNum())) continue;
            }
            resultList.add(curl);
        }
        return resultList;
    }

    //插入记录
    public CurlDirection insertInfo(CurlDirection curlreq) {
        //先查询记录
        Optional<CurlDirection> curlDirectionList = curlDirectionDAO.findInfoByIdAndNum(curlreq.getid(), curlreq.getNum());
        //不存在则插入
        if(curlDirectionList.isEmpty()) {
            CurlDirection newCurlDirection = new CurlDirection();
            newCurlDirection.setid(curlreq.getid());
            newCurlDirection.setdemand(curlreq.getdemand());
            newCurlDirection.setNum(curlreq.getNum());
            CurlDirection save = curlDirectionDAO.save(newCurlDirection);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String cusId) {
        //先找
        Optional<CurlDirection> curlDirectionList = curlDirectionDAO.findById(cusId);
        //找不到
        if(curlDirectionList.isEmpty()) return false;
        //找到了再删除
        curlDirectionDAO.deleteById(cusId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(CurlDirection curlreq) {
        //先查询记录
        Optional<CurlDirection> curl = curlDirectionDAO.findInfoByIdAndNum(curlreq.getid(), curlreq.getNum());
        //不存在
        if(curl.isEmpty()) return false;
        else {
            curl.get().setid(curlreq.getid());
            curl.get().setdemand(curlreq.getdemand());
            curl.get().setNum(curlreq.getNum());
            curlDirectionDAO.save(curl.get());
            return true;
        }
    }


    /**
     * GET /reqGetAllCustDire : 获取卷曲描述信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取卷曲描述信息", nickname = "curlDirectionGet", notes = "", response = Object.class, tags={ "卷曲描述表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllCustDire",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> curlDirectionGet() {
        List<CurlDirection> curlDirections = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(curlDirections);
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
     * POST /reqAddCustDire : 新建卷曲描述信息
     *
     * @param dirDescription  (optional)
     * @param cusId  (optional)
     * @return 成功 (status code 201)
     */
    @ApiOperation(value = "新建卷曲描述信息", nickname = "curlDirectionPost", notes = "", response = Object.class, tags={ "卷曲描述表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddCustDire",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> curlDirectionPost(@ApiParam(value = "", required=true) @RequestBody CurlDirection curlreq) {
        String code;
        CurlDirection save = insertInfo(curlreq);
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


    /**
     * DELETE /reqDelCustDire : 删除卷曲描述信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除卷曲描述信息", nickname = "curlDirectioncusIdDelete", notes = "", response = Object.class, tags={ "卷曲描述表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelCustDire",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> curlDirectioncusIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String cusId, @ApiParam(value = "",required=true) @RequestParam("num") String num) {
        String code;
        curlDirectionDAO.deleteInfoByIdAndNum(cusId, num);
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

    }


    /**
     * POST /reqGetCustDire : 根据项目id获取卷曲描述信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据项目id获取卷曲描述信息", nickname = "curlDirectioncusIdGet", notes = "", response = Object.class, tags={ "卷曲描述表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetCustDire",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> curlDirectioncusIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String cusId) {
        List<CurlDirection> curlDirections = curlDirectionDAO.findByCusId(cusId);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    String objectJson = JSON.toJSONString(curlDirections);
                    exampleString += objectJson;
                    exampleString += "}";

                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("根据id查询记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);


    }


    /**
     * PUT /reqSetCustDire : 修改卷曲描述信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改卷曲描述信息", nickname = "curlDirectioncusIdPut", notes = "", response = Object.class, tags={ "卷曲描述表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetCustDire",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> curlDirectioncusIdPut(@ApiParam(value = "", required=true) @RequestBody CurlDirection curlreq) {
        String code;

        changeFlag = changeInfoById(curlreq);
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

}
