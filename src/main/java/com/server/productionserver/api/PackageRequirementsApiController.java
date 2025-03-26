package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.PackageRequirementsDAO;
import com.server.productionserver.model.Item;
import com.server.productionserver.model.PackageRequirements;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class PackageRequirementsApiController implements PackageRequirementsApi {

    private final NativeWebRequest request;

    @Autowired
    PackageRequirementsDAO packageRequirementDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public PackageRequirementsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<PackageRequirements> findAllInfo() {
        List<PackageRequirements> PackageRequirementsList = packageRequirementDAO.findAll();
        return PackageRequirementsList;
    }

    //插入记录
    public PackageRequirements insertInfo(PackageRequirements pacreq) {
        //先查询记录
        Optional<PackageRequirements> PackageRequirementList = packageRequirementDAO.findInfoByIdAndNum(pacreq.getid(), pacreq.getNum());
        //不存在则插入
        if(PackageRequirementList.isEmpty()) {
            PackageRequirements newPackageRequirement = new PackageRequirements();
            newPackageRequirement.setid(pacreq.getid());
            newPackageRequirement.setdemand(pacreq.getdemand());
            newPackageRequirement.setNum(pacreq.getNum());
            PackageRequirements save = packageRequirementDAO.save(newPackageRequirement);
            return save;
        }
        //数据已存在
        return null;
    }

//    //根据id和num子串查找
//    public List<PackageRequirements> findByIdAndNum(String cusId, String num) {
//        List<PackageRequirements> allList = PackageRequirementDAO.findAll();
//        List<PackageRequirements> resultList = new ArrayList<>();
//
//        for(PackageRequirements pack : allList) {
//            if(cusId != null && !cusId.isEmpty()) {
//                if(!pack.getid().equals(cusId)) continue;
//            }
//            if(num != null && !num.isEmpty()) {
//                if(!num.contains(pack.getNum())) continue;
//            }
//            resultList.add(pack);
//        }
//        return resultList;
//    }


    //根据id修改记录
    public boolean changeInfoById(PackageRequirements pacreq) {
        //先查询记录
        Optional<PackageRequirements> pack = packageRequirementDAO.findInfoByIdAndNum(pacreq.getid(), pacreq.getNum());
        //不存在
        if(pack.isEmpty()) return false;
        else {
            pack.get().setid(pacreq.getid());
            pack.get().setdemand(pacreq.getdemand());
            pack.get().setNum(pacreq.getNum());
            packageRequirementDAO.save(pack.get());
            return true;
        }
    }


    /**
     * GET /reqGetAllCustPacReq : 获取所有打包要求信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取所有打包要求信息", nickname = "packageRequirementsGet", notes = "", response = Object.class, tags={ "打包要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllCustPacReq",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> packageRequirementsGet() {
        List<PackageRequirements> packageRequirements = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(packageRequirements);
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
     * POST /reqAddCustPacReq : 新建打包要求信息
     *
     * @param pacDescription  (optional)
     * @param cusId  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "新建打包要求信息", nickname = "packageRequirementsPost", notes = "", response = Object.class, tags={ "打包要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddCustPacReq",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> packageRequirementsPost(@ApiParam(value = "", required=true) @RequestBody PackageRequirements pacreq) {

        String code;
        PackageRequirements save = insertInfo(pacreq);
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
     * POST /reqGetCustPacReq : 根据项目id获取打包要求
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据项目id获取打包要求", nickname = "packageRequirementscusIdGet", notes = "", response = Object.class, tags={ "打包要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetCustPacReq",
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> packageRequirementscusIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String cusId) {
        List<PackageRequirements> packageRequirements = packageRequirementDAO.findByCusId(cusId);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    String objectJson = JSON.toJSONString(packageRequirements);
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
     * DELETE /reqDelCustPacReq : 根据id、num删除打包要求信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除打包要求信息", nickname = "packageRequirementscusIdDelete", notes = "", response = Object.class, tags={ "打包要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelCustPacReq",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> packageRequirementscusIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String cusId, @ApiParam(value = "",required=true) @RequestParam("num") String num) {

        String code;
        packageRequirementDAO.deleteInfoByIdAndNum(cusId, num);
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
     * PUT /reqSetCustPacReq : 修改打包要求信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改打包要求信息", nickname = "packageRequirementsPut", notes = "", response = Object.class, tags={ "打包要求表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetCustPacReq",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> packageRequirementsPut(@ApiParam(value = "", required=true) @RequestBody PackageRequirements pacreq) {
        String code;

        changeFlag = changeInfoById(pacreq);
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
