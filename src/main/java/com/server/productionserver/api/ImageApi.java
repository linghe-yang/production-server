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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "image", description = "the image API")
public interface ImageApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /uploadLogo : 插入图片信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入零件报表信息", nickname = "imagePost", notes = "", response = Object.class, tags={ "图片表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/uploadLogo",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> uploadLogo(@ApiParam(value = "", required=true) @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

//    /**
//     * GET /downloadLogo : 获取图片信息
//     *
//     * @return 成功 (status code 200)
//     */
//    @ApiOperation(value = "获取零件报表信息", nickname = "imageGet", notes = "", response = Object.class, tags={ "图片表", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "成功", response = Object.class) })
//    @RequestMapping(value = "/downloadLogo",
//            produces = { "application/json" },
//            consumes = { "multipart/form-data" },
//            method = RequestMethod.GET)
//    default ResponseEntity<Object> downloadLogo(@ApiParam(value = "", required=true) @RequestParam(value = "cus_id") String cusId) {
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }

//    /**
//     * DELETE /deleteLogo : 删除图片信息
//     *
//     * @return 成功 (status code 200)
//     */
//    @ApiOperation(value = "删除图片信息", nickname = "imageDelete", notes = "", response = Object.class, tags={ "图片表", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "成功", response = Object.class),
//            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
//    @RequestMapping(value = "/deleteLogo",
//            produces = { "application/json" },
//            consumes = { "multipart/form-data" },
//            method = RequestMethod.DELETE)
//    default ResponseEntity<Object> deleteLogo(@ApiParam(value = "",required=true) @RequestParam("cus_id") String cusId) {
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }

}
