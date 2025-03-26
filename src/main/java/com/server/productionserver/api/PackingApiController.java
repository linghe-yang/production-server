package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.PackingDAO;
import com.server.productionserver.DAO.ProductionDAO;
import com.server.productionserver.model.Packing;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-10T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class PackingApiController implements PackingApi {

    private final NativeWebRequest request;

    @Autowired
    PackingDAO packingDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public PackingApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public List<Packing> getPackingList(String workNum) {
        return packingDAO.findByWorkNum(workNum);
    }


    /**
     * POST /reqGetPacking : 获取packing表
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取packing", nickname = "packingGet", notes = "", response = Object.class, tags={ "装箱单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetPacking",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> packingGet(@ApiParam(value = "", required=true) @RequestParam(value="work_num", required=true)  String workNum) {

        List<Packing> allList =  getPackingList(workNum);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \" " + code + " \", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(allList);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("获取装箱单表请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
