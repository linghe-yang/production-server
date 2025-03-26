package com.server.productionserver.api;

import com.server.productionserver.model.LargeProject;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * @version 1.0
 * @auther Ethan
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@Validated
@Api(value = "largeProject", description = "the largeProject API")
public interface LargeProjectApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /deleteLargeProject : 根据名称删除信息
     *
     * @param projectName (required)
     * @return 成功 (status code 200)
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/deleteLargeProject",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> largeProjectDelete(@ApiParam(value = "", required = true) @RequestParam("project_name") String projectName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /getLargeProject : 根据名称获取信息
     *
     * @param projectName (required)
     * @return 成功 (status code 200)
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/getLargeProject",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> largeProjectGet(@ApiParam(value = "", required = true) @RequestParam("project_name") String projectName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /enterLargeProject : 新增信息
     *
     * @return 成功 (status code 200)
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/enterLargeProject",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> largeProjectEnter(@ApiParam(value = "", required=true) @RequestBody LargeProject largeProject) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
