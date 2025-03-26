package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ItemDAO;
import com.server.productionserver.DAO.MotherBillDAO;
import com.server.productionserver.model.Box;
import com.server.productionserver.model.Item;
import com.server.productionserver.model.MotherBill;
import com.server.productionserver.model.ProductNotice;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class MotherBillApiController implements MotherBillApi {

    private final NativeWebRequest request;
    private boolean deleteFlag;
    private boolean insertFlag;

    @Autowired
    MotherBillDAO motherBillDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public MotherBillApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //插入记录
    public boolean insertInfo(MotherBill motherBill) {
        Optional<MotherBill> bill = motherBillDAO.findById(motherBill.getMbNum());
        if(bill.isPresent()) {
            //记录存在，覆盖插入
            MotherBill existingBill = bill.get();
            existingBill.setEnterDate(motherBill.getEnterDate());
            existingBill.setCustomerName(motherBill.getCustomerName());
            existingBill.setHouseType(motherBill.getHouseType());
            existingBill.setNoticeNum(motherBill.getNoticeNum());
            existingBill.setProjectName(motherBill.getProjectName());
            existingBill.setSetNum(motherBill.getSetNum());
            existingBill.setFullLength(motherBill.getFullLength());
            existingBill.setPieceNum(motherBill.getPieceNum());
            existingBill.setOrganRequire(motherBill.getOrganRequire());
            existingBill.setFullArea(motherBill.getFullArea());
            existingBill.setProductArea(motherBill.getProductArea());
            existingBill.setPackDemand(motherBill.getPackDemand());
            existingBill.setOrientation(motherBill.getOrientation());
            existingBill.setFullPieceNum(motherBill.getFullPieceNum());
            motherBillDAO.save(existingBill);
            return true;
        } else {
            //记录不存在，新建记录
            MotherBill newBill = new MotherBill();
            newBill.setMbNum(motherBill.getMbNum());
            newBill.setEnterDate(motherBill.getEnterDate());
            newBill.setCustomerName(motherBill.getCustomerName());
            newBill.setHouseType(motherBill.getHouseType());
            newBill.setNoticeNum(motherBill.getNoticeNum());
            newBill.setProjectName(motherBill.getProjectName());
            newBill.setSetNum(motherBill.getSetNum());
            newBill.setFullLength(motherBill.getFullLength());
            newBill.setPieceNum(motherBill.getPieceNum());
            newBill.setOrganRequire(motherBill.getOrganRequire());
            newBill.setFullArea(motherBill.getFullArea());
            newBill.setProductArea(motherBill.getProductArea());
            newBill.setPackDemand(motherBill.getPackDemand());
            newBill.setOrientation(motherBill.getOrientation());
            newBill.setFullPieceNum(motherBill.getFullPieceNum());
            motherBillDAO.save(newBill);
            return true;
        }
    }

    //根据id删除记录
    public boolean deleteInfoById(String mbNum) {
        //先找
        Optional<MotherBill> motherBill = motherBillDAO.findById(mbNum);
        //找不到
        if(motherBill.isEmpty()) return false;
        //找到了再删除
        motherBillDAO.deleteById(mbNum);
        return true;
    }

    //条件查询记录
    public List<MotherBill> findCertainInfo(String beginTime, String endTime, String mbNum) {
        List<MotherBill> allList = motherBillDAO.findAll();
        List<MotherBill> resultList = new ArrayList<>();

        for(MotherBill bill: allList) {
            if(mbNum != null && !mbNum.isEmpty()) {
                if(!bill.getMbNum().contains(mbNum)) continue;
            }
            if(beginTime != null && !beginTime.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate beginDate = LocalDate.parse(beginTime, formatter);
                LocalDate nowDate = LocalDate.parse(bill.getEnterDate(), formatter);
                if(nowDate.isBefore(beginDate)) continue;
            }
            if(endTime != null && !endTime.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate endDate = LocalDate.parse(endTime, formatter);
                LocalDate nowDate = LocalDate.parse(bill.getEnterDate(), formatter);
                if(nowDate.isAfter(endDate)) continue;
            }
            resultList.add(bill);
        }
        return resultList;
    }


    /**
     * POST /motherBill/enter: 录入母单
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "录入母单", nickname = "motherBillPost", notes = "", response = Object.class, tags={ "母单", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/motherBill/enter",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> motherBillPost(@ApiParam(value = "", required=true) @RequestBody MotherBill motherBill) {
        insertFlag = insertInfo(motherBill);
        if(insertFlag) {
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
        } else {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+403+", \"data\" : [ ";
                        exampleString += " ]}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("插入记录失败！记录已存在。");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    /**
     * POST /motherBill/getById : 根据主键获取母单
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据主键获取母单", nickname = "motherBillGet", notes = "", response = Object.class, tags={ "母单", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/motherBill/getById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> motherBillGet(@ApiParam(value = "", required=true) @RequestParam(value = "mb_num") String mbNum) {
        List<MotherBill> motherBill = motherBillDAO.findByContaining(mbNum);
        String code;

        if(!motherBill.isEmpty()) {
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : \""+code+"\", \"data\" :";
                        String objectJson = JSON.toJSONString(motherBill);
                        exampleString += objectJson;
                        exampleString += "}";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据id查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            code = "404";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : \""+code+"\", \"data\" :";
                        String objectJson = JSON.toJSONString(motherBill);
                        exampleString += objectJson;
                        exampleString += "}";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("根据id查询记录请求失败!记录不存在！");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /motherBill/getList : 条件查询母单
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "条件查询母单", nickname = "motherBillGetList", notes = "", response = Object.class, tags={ "母单", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/motherBill/getList",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> motherBillGetList(@ApiParam(value = "", required=false) @RequestParam(value = "begin_time") String beginTime, @ApiParam(value = "", required=false) @RequestParam(value = "end_time") String endTime, @ApiParam(value = "", required=false) @RequestParam(value = "mb_num") String mbNum) {
        List<MotherBill> bills = findCertainInfo(beginTime, endTime, mbNum);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" :  ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(bills);
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
     * DELETE /motherBill/deleteById : 根据主键删除母单
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据主键删除母单", nickname = "motherBillDelete", notes = "", response = Object.class, tags={ "母单", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
    @RequestMapping(value = "/motherBill/deleteById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> motherBillDelete(@ApiParam(value = "",required=true) @RequestParam("mb_num") String mbNum) {
        String code;
        deleteFlag = deleteInfoById(mbNum);
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

}
