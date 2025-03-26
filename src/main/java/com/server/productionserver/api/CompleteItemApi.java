package com.server.productionserver.api;

import com.server.productionserver.model.CompleteItem;
import com.server.productionserver.model.Item;
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

@Validated
@Api(value = "completeItem", description = "the completeItem API")
public interface CompleteItemApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /output/get : 获取零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取完成零件信息", nickname = "completeItemGet", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/output/get",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> completeItemGet(@ApiParam(value = "", required=false) @RequestParam(value = "beginDate") String beginDate,
                                                   @ApiParam(value = "", required=false) @RequestParam(value = "end_date") String endDate,
                                                   @ApiParam(value = "", required=false) @RequestParam(value = "staff_name") String staffName,
                                                   @ApiParam(value = "", required=false) @RequestParam(value = "staff_job") String staffJob,
                                                   @ApiParam(value = "", required=false) @RequestParam(value = "work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /output/enter : 插入零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入完成零件信息", nickname = "completeItemPost", notes = "", response = Object.class, tags={ "报表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/enter",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> completeItemPost(@ApiParam(value = "", required=true) @RequestBody List<CompleteItem> itemList) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /output/delete : 删除零件报表信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除零件信息", nickname = "completeItemDelete", notes = "", response = Object.class, tags={ "生产通知单表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/output/delete",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> productNoticeDelete(@ApiParam(value = "", required=true) @RequestBody List<Long> idList) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
