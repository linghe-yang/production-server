package com.server.productionserver.api;
import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ProductionDAO;
import com.server.productionserver.model.Production;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-10T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ProductionApiController implements ProductionApi{
    private final NativeWebRequest request;

    @Autowired
    ProductionDAO productionDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductionApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Production> findAllInfo() {
        List<Production> ProductionList = productionDAO.findAll();
        return ProductionList;
    }

    //根据id查询记录
    public Optional<Production> findInfoById(String Id) {
        Optional<Production> ProductionList = productionDAO.findById(Id);
        return ProductionList;
    }

    //插入记录
    public Production insertInfo(Production production) {
        //先查询记录
        Optional<Production> ProductionList = productionDAO.findById(production.getid());
        //不存在则插入
        if(ProductionList.isEmpty()) {
            Production newProduction = new Production();
            newProduction.setid(production.getid());
            newProduction.setname(production.getname());
            newProduction.setsize(production.getsize());
            newProduction.setcost(production.getcost());
            newProduction.setproClass(production.getproClass());
            Production save = productionDAO.save(newProduction);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String ProductionId) {
        //先找
        Optional<Production> ProductionList = productionDAO.findById(ProductionId);
        //找不到
        if(ProductionList.isEmpty()) return false;
        //找到了再删除
        productionDAO.deleteById(ProductionId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(Production production) {
        //先查询记录
        Optional<Production> ProductionList = productionDAO.findById(production.getid());
        //不存在
        if(ProductionList.isEmpty()) return false;
        else {
            Production newProduction = new Production();
            newProduction.setid(production.getid());
            newProduction.setname(production.getname());
            newProduction.setsize(production.getsize());
            newProduction.setcost(production.getcost());
            newProduction.setproClass(production.getproClass());
            productionDAO.save(newProduction);
            return true;
        }
    }

    /**
     * DELETE /reqDelProduct : 根据id删除产品信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除产品信息", nickname = "producitonIdDelete", notes = "", response = Object.class, tags={ "产品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "找不到记录", response = Object.class)})
    @RequestMapping(value = "/reqDelProduct",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> productionIdDelete(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String productionId) {
        String code;
        deleteFlag = deleteInfoById(productionId);
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
     * POST /reqGetProduct : 根据id获取产品信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取产品信息", nickname = "productionIdGet", notes = "", response = Object.class, tags={ "产品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetProduct",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> productionIdGet(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String productionId) {
        Optional<Production> productions = findInfoById(productionId);
        String code = "200";

        if(productions.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [";
                        String objectJson = JSON.toJSONString(productions);
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

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [";
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
     * PUT /reqSetProduct : 修改产品信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改产品信息", nickname = "productionPut", notes = "", response = Object.class, tags={ "产品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqSetProduct",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> productionPut(@ApiParam(value = "", required=true) @RequestBody Production production) {
        String code;
        changeFlag = changeInfoById(production);
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
     * GET /reqGetAllProduct : 查询全部产品
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部产品", nickname = "productionGet", notes = "", response = Object.class, tags={ "产品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllProduct",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> boxGet() {
        List<Production> productions = findAllInfo();
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(productions);
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
     * POST /reqAddProduct : 插入产品信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入产品信息", nickname = "productionPost", notes = "", response = Object.class, tags={ "产品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "禁止访问", response = Object.class)})
    @RequestMapping(value = "/reqAddProduct",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> productionPost(@ApiParam(value = "", required=true) @RequestBody Production production) {
        String code;
        Production save = insertInfo(production);
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
