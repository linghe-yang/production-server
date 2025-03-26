package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ExpressCompanyDAO;
import com.server.productionserver.model.ExpressCompany;
import com.server.productionserver.model.Project;
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
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ExpressCompanyApiController implements ExpressCompanyApi {

    private final NativeWebRequest request;

    @Autowired
    ExpressCompanyDAO expressCompanyDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpressCompanyApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<ExpressCompany> findAllInfo() {
        List<ExpressCompany> ExpressCompanyList = expressCompanyDAO.findAll();
        return ExpressCompanyList;
    }

    //根据id查询记录
    public Optional<ExpressCompany> findInfoById(String Id) {
        Optional<ExpressCompany> ExpressCompanyList = expressCompanyDAO.findById(Id);
        return ExpressCompanyList;
    }

    //插入记录
    public ExpressCompany insertInfo(String workId, String ExpressCompanyName) {
        //先查询记录
        Optional<ExpressCompany> ExpressCompanyList = expressCompanyDAO.findById(workId);
        //不存在则插入
        if(ExpressCompanyList.isEmpty()) {
            ExpressCompany newExpressCompany = new ExpressCompany();
            newExpressCompany.setworkId(workId);
            newExpressCompany.setExpressName(ExpressCompanyName);
            ExpressCompany save = expressCompanyDAO.save(newExpressCompany);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String workId) {
        //先找
        Optional<ExpressCompany> ExpressCompanyList = expressCompanyDAO.findById(workId);
        //找不到
        if(ExpressCompanyList.isEmpty()) return false;
        //找到了再删除
        expressCompanyDAO.deleteById(workId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(String workId, String ExpressCompanyName) {
        //先查询记录
        Optional<ExpressCompany> ExpressCompanyList = expressCompanyDAO.findById(workId);
        //不存在
        if(ExpressCompanyList.isEmpty()) return false;
        else {
            ExpressCompany newExpressCompany = new ExpressCompany();
            newExpressCompany.setworkId(workId);
            newExpressCompany.setExpressName(ExpressCompanyName);
            expressCompanyDAO.save(newExpressCompany);
            return true;
        }
    }

    /**
     * GET /express_company : 查询所有快递公司信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询所有快递公司信息", nickname = "expressCompanyGet", notes = "", response = Object.class, tags={ "快递公司表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/express_company",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> expressCompanyGet() {
        List<ExpressCompany> expressCompanies = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(expressCompanies);
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
     * POST /express_company : 插入快递公司信息
     *
     * @param expressName  (optional)
     * @param workId  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入快递公司信息", nickname = "expressCompanyPost", notes = "", response = Object.class, tags={ "快递公司表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/express_company",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> expressCompanyPost(@ApiParam(value = "") @Valid @RequestParam(value = "express_name", required = false) String expressName, @ApiParam(value = "") @Valid @RequestParam(value = "work_id", required = false) String workId) {
        String code;
        ExpressCompany save = insertInfo(workId, expressName);
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


    /**
     * DELETE /express_company/deleteById : 根据id删除快递公司信息
     *
     * @param workId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据项目id删除快递公司信息", nickname = "expressCompanyworkIdDelete", notes = "", response = Object.class, tags={ "快递公司表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/express_company/deleteById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> expressCompanyworkIdDelete(@ApiParam(value = "",required=true) @RequestParam("work_id") String workId) {
        String code;
        deleteFlag = deleteInfoById(workId);
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
     * GET /express_company/getById : 根据id查询快递公司信息
     *
     * @param workId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据项目id查询快递公司信息", nickname = "expressCompanyworkIdGet", notes = "", response = Object.class, tags={ "快递公司表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/express_company/getById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> expressCompanyworkIdGet(@ApiParam(value = "",required=true) @RequestParam("work_id") String workId) {
        Optional<ExpressCompany> expressCompany = findInfoById(workId);
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    String objectJson = JSON.toJSONString(expressCompany);
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

}
