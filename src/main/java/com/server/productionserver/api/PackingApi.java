package com.server.productionserver.api;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-09T17:21:33.341303800+08:00[Asia/Shanghai]")

@Validated
@Api(value = "packing", description = "the production API")
public interface PackingApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
    default ResponseEntity<Object> packingGet(@ApiParam(value = "", required=true) @RequestParam(value="work_num", required=true)  String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
