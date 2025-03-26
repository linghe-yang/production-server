package com.server.productionserver.api;


import com.server.productionserver.model.Item;
import com.server.productionserver.model.MotherBill;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")

@Validated
@Api(value = "motherBill", description = "the motherBill API")
public interface MotherBillApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
    default ResponseEntity<Object> motherBillPost(@ApiParam(value = "", required=true) @RequestBody MotherBill motherBill) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<Object> motherBillGet(@ApiParam(value = "", required=true) @RequestParam(value = "mb_num") String mbNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
    default ResponseEntity<Object> motherBillGetList(@ApiParam(value = "", required=false) @RequestParam(value = "begin_time") String beginTime, @ApiParam(value = "", required=false) @RequestParam(value = "end_time") String endTime, @ApiParam(value = "", required=false) @RequestParam(value = "mb_num") String mbNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
    default ResponseEntity<Object> motherBillDelete(@ApiParam(value = "",required=true) @RequestParam("mb_num") String mbNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
