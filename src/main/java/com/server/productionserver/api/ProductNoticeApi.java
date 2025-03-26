package com.server.productionserver.api;

import com.server.productionserver.model.ProductNotice;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@Validated
@Api(value = "productNotice", description = "the productNotice API")
public interface ProductNoticeApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }


    /**
     * POST /productNotice/getList : 查询全部信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部信息", nickname = "productNoticeGet", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/productNotice/getList",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> productNoticeGet(@ApiParam(value = "", required=false) @RequestParam(value = "work_num") String workId, @ApiParam(value = "") @RequestParam(value = "begin_time", required = false) String beginTime, @ApiParam(value = "") @RequestParam(value = "end_time", required = false) String endTime) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<Object> productNoticePost(@ApiParam(value = "", required=true) @RequestBody ProductNotice formHead) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<Object> productNoticeDelete(@ApiParam(value = "",required=true) @RequestParam("work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<Object> productNoticeproductNoticeIdGet(@ApiParam(value = "",required=true) @RequestParam("work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
