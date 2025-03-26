package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.OrganizationRequirementsDAO;
import com.server.productionserver.model.OrganizationRequirements;
import com.server.productionserver.model.PackageRequirements;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.aspectj.weaver.ast.Or;
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
public class OrganizationRequirementsApiController implements OrganizationRequirementsApi {

    private final NativeWebRequest request;

    @Autowired
    OrganizationRequirementsDAO organizationRequirementsDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationRequirementsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<OrganizationRequirements> findAllInfo() {
        List<OrganizationRequirements> OrganizationRequirementsList = organizationRequirementsDAO.findAll();
        return OrganizationRequirementsList;
    }

//    //根据id查询记录
//    public List<OrganizationRequirements> findInfoByIdAndNum(String cusId, String num) {
//        List<OrganizationRequirements> allList = organizationRequirementsDAO.findAll();
//        List<OrganizationRequirements> resultList = new ArrayList<>();
//
//        for(OrganizationRequirements organ : allList) {
//            if(cusId != null && !cusId.isEmpty()) {
//                if(!organ.getid().equals(cusId)) continue;
//            }
//            if(num != null && !num.isEmpty()) {
//                if(!num.contains(organ.getNum())) continue;
//            }
//            resultList.add(organ);
//        }
//        return resultList;
//    }

    //插入记录
    public OrganizationRequirements insertInfo(OrganizationRequirements orgreq) {
        //先查询记录
        Optional<OrganizationRequirements> OrganizationRequirementList = organizationRequirementsDAO.findInfoByIdAndNum(orgreq.getid(), orgreq.getNum());
        //不存在则插入
        if(OrganizationRequirementList.isEmpty()) {
            OrganizationRequirements newOrganizationRequirement = new OrganizationRequirements();
            newOrganizationRequirement.setid(orgreq.getid());
            newOrganizationRequirement.setdemand(orgreq.getdemand());
            newOrganizationRequirement.setNum(orgreq.getNum());
            OrganizationRequirements save = organizationRequirementsDAO.save(newOrganizationRequirement);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String cusId) {
        //先找
        Optional<OrganizationRequirements> OrganizationRequirementList = organizationRequirementsDAO.findById(cusId);
        //找不到
        if(OrganizationRequirementList.isEmpty()) return false;
        //找到了再删除
        organizationRequirementsDAO.deleteById(cusId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(OrganizationRequirements orgreq) {
        //先查询记录
        Optional<OrganizationRequirements> organ = organizationRequirementsDAO.findInfoByIdAndNum(orgreq.getid(), orgreq.getNum());
        //不存在
        if(organ.isEmpty()) return false;
        else {
            organ.get().setid(orgreq.getid());
            organ.get().setdemand(orgreq.getdemand());
            organ.get().setNum(orgreq.getNum());
            organizationRequirementsDAO.save(organ.get());
            return true;
        }
    }



    /**
     * GET /reqGetAllCustOrderReq : 获取整理要求信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取整理要求信息", nickname = "organizationRequirementsGet", notes = "", response = Object.class, tags={ "整理要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllCustOrderReq",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> organizationRequirementsGet() {
        List<OrganizationRequirements> organizationRequirements = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(organizationRequirements);
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
     * POST /reqAddCustOrderReq : 新建整理要求信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "新建整理要求信息", nickname = "organizationRequirementsPost", notes = "", response = Object.class, tags={ "整理要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddCustOrderReq",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> organizationRequirementsPost(@ApiParam(value = "", required=true) @RequestBody OrganizationRequirements orgreq) {

        String code;
        OrganizationRequirements save = insertInfo(orgreq);
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
     * DELETE /reqDelCustOrderReq : 根据id删除整理要求信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除整理要求信息", nickname = "organizationRequirementscusIdDelete", notes = "", response = Object.class, tags={ "整理要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelCustOrderReq",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> organizationRequirementscusIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String cusId, @ApiParam(value = "",required=true) @RequestParam("num") String num) {
        String code;
        organizationRequirementsDAO.deleteInfoByIdAndNum(cusId, num);
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
     * POST /reqGetCustOrderReq : 根据id获取整理要求信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取整理要求信息", nickname = "organizationRequirementscusIdGet", notes = "", response = Object.class, tags={ "整理要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetCustOrderReq",
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> organizationRequirementscusIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String cusId) {
        List<OrganizationRequirements> organizationRequirements = organizationRequirementsDAO.findByCusId(cusId);
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" :";
                    String objectJson = JSON.toJSONString(organizationRequirements);
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
     * PUT /reqSetCustOrderReq : 修改整理要求信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改整理要求信息", nickname = "organizationRequirementsPut", notes = "", response = Object.class, tags={ "整理要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetCustOrderReq",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> organizationRequirementsPut(@ApiParam(value = "", required=true) @RequestBody OrganizationRequirements orgreq) {
        String code;

        changeFlag = changeInfoById(orgreq);
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
