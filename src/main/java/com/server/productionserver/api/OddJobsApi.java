package com.server.productionserver.api;

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

/**
 * 杂活备注表接口
 */

@Validated
@Api(value = "OddJobs", description = "the OddJobsApi API")
public interface OddJobsApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /output/getoddjobs : 获取杂活信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取杂活信息", nickname = "completeItemGet", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/output/getoddjobs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> oddJobsGet(@ApiParam(value = "", required=false) @RequestParam(value = "begin_date") String beginDate, @ApiParam(value = "", required=false) @RequestParam(value = "end_date") String endDate) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /output/enteroddjobs : 插入杂活信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入杂活信息", nickname = "oddJobsPost", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/enteroddjobs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> oddJobsPost(@ApiParam(value = "", required=false) @RequestParam(value = "date") String date, @ApiParam(value = "", required=false) @RequestParam(value = "stuff_name") String stuffName, @ApiParam(value = "", required=false) @RequestParam(value = "other") String other) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /output/deleteoddjobs : 删除杂活信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除杂活信息", nickname = "oddJobsDelete", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/deleteoddjobs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> oddJobsDelete(@ApiParam(value = "", required=false) @RequestParam(value = "date") String date, @ApiParam(value = "", required=false) @RequestParam(value = "stuff_name") String stuffName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
