package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.CustomerDAO;
import com.server.productionserver.DAO.ImageDAO;
import com.server.productionserver.model.Customer;
import com.server.productionserver.model.Production;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class CustomerApiController implements CustomerApi {

    private final NativeWebRequest request;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    ImageDAO imageDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    //查询全部记录
    public List<Customer> findAllInfo() {
        List<Customer> customerList = customerDAO.findAll();
        return customerList;
    }

    //根据id查询记录
    public Optional<Customer> findInfoById(String Id) {
        Optional<Customer> customerList = customerDAO.findById(Id);
        return customerList;
    }

    //插入记录
    public Customer insertInfo(Customer customer) {
        //查询id是否重复
        Optional<Customer> customerList = customerDAO.findById(customer.getid());
        //查询是否有重名
        Optional<Customer> c = customerDAO.findByName(customer.getname());
        //不存在则插入
        if(customerList.isEmpty() && c.isEmpty()) {
            Customer newCustomer = new Customer();
            newCustomer.setid(customer.getid());
            newCustomer.setname(customer.getname());
            newCustomer.setOrderTime(customer.getOrderTime());
            newCustomer.setaddress(customer.getaddress());
            newCustomer.setphone(customer.getphone());
            newCustomer.setlogo(customer.getlogo());
            newCustomer.setProId(customer.getProId());
            Customer save = customerDAO.save(newCustomer);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String cusId) {
        //先找
        Optional<Customer> customerList = customerDAO.findById(cusId);
        //找不到
        if(customerList.isEmpty()) return false;
        //找到了再删除
        deleteImageByUrl(customerList.get().getlogo());
        customerDAO.deleteById(cusId);
        return true;

    }

    //删除图片
    void deleteImageByUrl(String imageUrl) {
        // 1. 从前端中获取文件路径为imageUrl

        if (imageUrl != null) {
            // 2. 删除文件
            boolean fileDeleted = deleteFile(imageUrl);
            if (fileDeleted) {
                // 3. 从数据库中删除记录
                imageDAO.deleteImageByUrl(imageUrl);
                System.out.println("Image deleted successfully.");
            } else {
                System.out.println("Failed to delete image file.");
            }
        } else {
            System.out.println("Image not found in the database.");
        }
    }

    //删除数据库图片记录
    private boolean deleteFile(String filePath) {
        try {
            java.nio.file.Path path = Paths.get(filePath);
            Files.deleteIfExists(path);
            return true;
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
            return false;
        }
    }

    //根据id修改记录
    public boolean changeInfoById(Customer customer) {
        //先查询记录
        Optional<Customer> customerList = customerDAO.findById(customer.getid());
        //不存在
        if(customerList.isEmpty()) return false;
        else {
            Customer newCustomer = new Customer();
            newCustomer.setid(customer.getid());
            newCustomer.setname(customer.getname());
            newCustomer.setOrderTime(customer.getOrderTime());
            newCustomer.setaddress(customer.getaddress());
            newCustomer.setphone(customer.getphone());
            newCustomer.setlogo(customer.getlogo());
            newCustomer.setProId(customer.getProId());
            customerDAO.save(newCustomer);
            return true;
        }
    }





    /**
     * DELETE /reqDelCustomer: 根据id删除客户信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除客户信息", nickname = "customerCusIdDelete", notes = "", response = Object.class, tags={ "客户表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqDelCustomer",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> customerCusIdDelete(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String cusId) {
        String code;
        deleteFlag = deleteInfoById(cusId);
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
     * POST /reqGetCustomer : 根据id获取客户信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取客户信息", nickname = "customerCusIdGet", notes = "", response = Object.class, tags={ "客户表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetCustomer",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> customerCusIdGet(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String cusId) {
        Optional<Customer> customers = findInfoById(cusId);
        String code = "200";

        if(customers.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(customers);
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
     * PUT /reqSetCustomer : 修改客户信息
     *
     * @param cusId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改客户信息", nickname = "customerCusIdPut", notes = "", response = Object.class, tags={ "客户表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqSetCustomer",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> customerCusIdPut(@ApiParam(value = "", required=true) @RequestBody Customer customer) {
        String code;

        changeFlag = changeInfoById(customer);
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
                        String result = "通过id修改数据成功!";
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
     * GET /reqGetAllCustomer : 查询全部客户信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部客户信息", nickname = "customerGet", notes = "", response = Object.class, tags={ "客户表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllCustomer",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> customerGet() {
        List<Customer> customers = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(customers);
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
     * POST /reqAddCustomer : 插入客户信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入客户信息", nickname = "customerPost", notes = "", response = Object.class, tags={ "客户表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "记录已存在", response = Object.class)})
    @RequestMapping(value = "/reqAddCustomer",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> customerPost(@ApiParam(value = "", required=true) @RequestBody Customer customer) {
        String code;
        Customer save = insertInfo(customer);
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
