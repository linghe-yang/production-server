package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ProductNoticeDAO;
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
import springfox.documentation.spring.web.json.Json;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

//生产通知表API
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ProductNoticeApiController implements ProductNoticeApi {

    private final NativeWebRequest request;


    @Autowired
    ProductNoticeDAO productNoticeDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductNoticeApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //条件查询记录
    public List<ProductNotice> findCertainInfo(String beginTime, String endTime, String workNum) {
        List<ProductNotice> allList = productNoticeDAO.findAll();
        List<ProductNotice> resultList = new ArrayList<>();

        for(ProductNotice productNotice: allList) {
            if(workNum != null && !workNum.isEmpty()) {
                if(!productNotice.getWorkNum().contains(workNum)) continue;
            }
            if(beginTime != null && !beginTime.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate beginDate = LocalDate.parse(beginTime, formatter);
                LocalDate nowDate = LocalDate.parse(productNotice.getEnterDate(), formatter);
                if(nowDate.isBefore(beginDate)) continue;
            }
            if(endTime != null && !endTime.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate endDate = LocalDate.parse(endTime, formatter);
                LocalDate nowDate = LocalDate.parse(productNotice.getEnterDate(), formatter);
                if(nowDate.isAfter(endDate)) continue;
            }
            resultList.add(productNotice);
        }
        return resultList;
    }


    //查询全部记录
    public List<ProductNotice> findAllInfo() {
        List<ProductNotice> allList = productNoticeDAO.findAll();
        return allList;
    }

    //插入记录
    public ProductNotice insertInfo(ProductNotice formHead) {
        //先查询记录
        Optional<ProductNotice> ProductNoticeList = productNoticeDAO.findById(formHead.getWorkNum());

        if(ProductNoticeList.isPresent()) {
            //如果workNum已存在则覆盖插入
            ProductNotice existingProductNotice = ProductNoticeList.get();
            existingProductNotice.setOrderDate(formHead.getOrderDate());
            existingProductNotice.setSetNum(formHead.getSetNum());
            existingProductNotice.setProjectName(formHead.getProjectName());
            existingProductNotice.setCustomerName(formHead.getCustomerName());
            existingProductNotice.setContractNum(formHead.getContractNum());
            existingProductNotice.setEnterDate(formHead.getEnterDate());
            existingProductNotice.setItemName(formHead.getItemName());
            existingProductNotice.setOrderTime(formHead.getOrderTime());
            existingProductNotice.setOrganRequire(formHead.getOrganRequire());
            existingProductNotice.setCheckReportNum(formHead.getCheckReportNum());
            existingProductNotice.setCredentialNum(formHead.getCredentialNum());
            existingProductNotice.setReceiptNum(formHead.getReceiptNum());
            existingProductNotice.setOther(formHead.getOther());
            existingProductNotice.setPackDemand(formHead.getPackDemand());
            existingProductNotice.setOrientation(formHead.getOrientation());
            existingProductNotice.setExpressCompany(formHead.getExpressCompany());
            existingProductNotice.setExpressNum(formHead.getExpressNum());
            existingProductNotice.setEnterStaff(formHead.getEnterStaff());
            existingProductNotice.setTotalNum(formHead.getTotalNum());
            existingProductNotice.setTotalProductNum(formHead.getTotalProductNum());
            existingProductNotice.setTotalLength(formHead.getTotalLength());
            existingProductNotice.setTotalArea(formHead.getTotalArea());
            existingProductNotice.setTotalProductArea(formHead.getTotalProductArea());
            ProductNotice save = productNoticeDAO.save(existingProductNotice);
            return save;
        } else {
            //记录不存在，则新建记录
            ProductNotice newProductNotice = new ProductNotice();
            newProductNotice.setWorkNum(formHead.getWorkNum());
            newProductNotice.setOrderDate(formHead.getOrderDate());
            newProductNotice.setSetNum(formHead.getSetNum());
            newProductNotice.setProjectName(formHead.getProjectName());
            newProductNotice.setCustomerName(formHead.getCustomerName());
            newProductNotice.setContractNum(formHead.getContractNum());
            newProductNotice.setEnterDate(formHead.getEnterDate());
            newProductNotice.setItemName(formHead.getItemName());
            newProductNotice.setOrderTime(formHead.getOrderTime());
            newProductNotice.setOrganRequire(formHead.getOrganRequire());
            newProductNotice.setCheckReportNum(formHead.getCheckReportNum());
            newProductNotice.setCredentialNum(formHead.getCredentialNum());
            newProductNotice.setReceiptNum(formHead.getReceiptNum());
            newProductNotice.setOther(formHead.getOther());
            newProductNotice.setPackDemand(formHead.getPackDemand());
            newProductNotice.setOrientation(formHead.getOrientation());
            newProductNotice.setExpressCompany(formHead.getExpressCompany());
            newProductNotice.setExpressNum(formHead.getExpressNum());
            newProductNotice.setEnterStaff(formHead.getEnterStaff());
            newProductNotice.setTotalNum(formHead.getTotalNum());
            newProductNotice.setTotalProductNum(formHead.getTotalProductNum());
            newProductNotice.setTotalLength(formHead.getTotalLength());
            newProductNotice.setTotalArea(formHead.getTotalArea());
            newProductNotice.setTotalProductArea(formHead.getTotalProductArea());
            ProductNotice save = productNoticeDAO.save(newProductNotice);
            return save;
        }
    }

    //根据id删除记录
    public boolean deleteInfoById(String workNum) {
        //先找
        Optional<ProductNotice> ProductNoticeList = productNoticeDAO.findById(workNum);
        //找不到
        if(ProductNoticeList.isEmpty()) return false;
        //找到了再删除
        productNoticeDAO.deleteById(workNum);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(String workNum) {
        //先查询记录
        Optional<ProductNotice> ProductNoticeList = productNoticeDAO.findById(workNum);
        //不存在
        if(ProductNoticeList.isEmpty()) return false;
        else {
            ProductNotice newProductNotice = new ProductNotice();
            newProductNotice.setWorkNum(workNum);
            productNoticeDAO.save(newProductNotice);
            return true;
        }
    }

    /**
     * POST /productNotice/getList : 条件查询全部信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "条件查询全部信息", nickname = "productNoticeGet", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/productNotice/getList",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> productNoticeGet(@ApiParam(value = "", required=false) @RequestParam(value = "work_num") String workNum, @ApiParam(value = "") @RequestParam(value = "begin_time", required = false) String beginTime, @ApiParam(value = "") @RequestParam(value = "end_time", required = false) String endTime) {
//        System.out.println(beginTime);
        List<ProductNotice> productNotices = findCertainInfo(beginTime, endTime, workNum);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" :  ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(productNotices);
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
     * POST /productNotice : 插入生产通知单信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入生产通知单信息", nickname = "productNoticePost", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "记录已存在", response = Object.class),})
    @RequestMapping(value = "/productNotice",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> productNoticePost(@ApiParam(value = "", required=true) @RequestBody ProductNotice formHead) {
        String code;
        ProductNotice save = insertInfo(formHead);
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
     * DELETE /productNotice/deleteById : 根据id删除生产通知单信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除生产通知单信息", nickname = "productNoticeDelete", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
    @RequestMapping(value = "/productNotice/deleteById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> productNoticeDelete(@ApiParam(value = "",required=true) @RequestParam("work_num") String workNum) {
        String code;
        deleteFlag = deleteInfoById(workNum);
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
     * POST /productNotice/getById : 根据id获取生产通知单信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取生产通知单信息", nickname = "productNoticeproductNoticeIdGet", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/productNotice/getById",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> productNoticeproductNoticeIdGet(@ApiParam(value = "",required=true) @RequestParam("work_num") String workNum) {
        List<ProductNotice> productNotices  = productNoticeDAO.findByContaining(workNum);

        if (productNotices != null && !productNotices.isEmpty()) {
            ProductNotice productNotice = productNotices.get(0);
            String code = "200";

            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : " + code + ", \"data\" : ";
                        String objectJson = JSON.toJSONString(productNotice); // 只返回单个 Object
                        exampleString += objectJson;
                        exampleString += " }";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据 id 查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            System.out.println("没有找到对应的生产通知单");
            String code = "200";

            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : " + code + ", \"data\" : null";
                        exampleString += " }";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据 id 查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
