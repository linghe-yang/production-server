package com.server.productionserver.api;

import com.server.productionserver.model.BackUpCom;
import com.server.productionserver.model.Box;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@Validated
@Api(value = "backupcom", description = "the backupcom API")
public interface BackUpComApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /reqDelSpareSpecs : 根据id删除信息
     *
     * @param boxId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除信息", nickname = "backUpIdDelete", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelSpareSpecs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> backUpIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /reqGetSpareSpecs : 根据id获取信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取信息", nickname = "backUpIdGet", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetSpareSpecs",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> backUpIdGet(@ApiParam(value = "",required=true) @RequestParam("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /reqSetSpareSpecs : 根据id修改信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改信息", nickname = "backUpIdPut", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetSpareSpecs",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    default ResponseEntity<Object> backUpIdPut(@ApiParam(value = "", required=true) @RequestBody BackUpCom backupcom) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /reqGetAllSpareSpecs : 查询全部
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部", nickname = "backUpGet", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllSpareSpecs",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> backUpGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /reqAddSpareSpecs : 插入箱信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入信息", nickname = "backUpPost", notes = "", response = Object.class, tags={ "备品表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddSpareSpecs",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> backUpPost(@ApiParam(value = "", required=true) @RequestBody BackUpCom backupcom) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
