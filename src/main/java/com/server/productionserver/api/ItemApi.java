package com.server.productionserver.api;

import com.server.productionserver.DTO.ItemDTO;
import com.server.productionserver.model.Item;
import com.server.productionserver.model.Labels;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "item", description = "the item API")
public interface ItemApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /reqStaffGetCpf : 获取零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取零件报表信息", nickname = "itemGet", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqStaffGetCpf",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> itemGet(@ApiParam(value = "", required = false) @RequestParam(value = "form_type") Integer formType, @ApiParam(value = "", required = false) @RequestParam(value = "work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /reqStaffPostCpf : 插入零件信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入零件报表信息", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqStaffPostCpf",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> itemPost(@ApiParam(value = "", required = true) @RequestBody List<Item> itemList) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /reqStaffDeleteCpf : 根据workNum删除零件报表信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除零件报表信息", nickname = "itemDelete", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqStaffDeleteCpf",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> itemDelete(@ApiParam(value = "", required = true) @RequestParam("work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /reqChangeItem : 修改零件状态
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改零件状态", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/reqChangeItem",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> itemChange(@ApiParam(value = "", required = true) @RequestBody List<ItemDTO> itemDTOList) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /getNoticeBoxMarks : 获取去重箱号
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取去重箱号", nickname = "itemPost", notes = "", response = Object.class, tags = {"零件报表",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class)})
    @RequestMapping(value = "/getNoticeBoxMarks",
            produces = {"application/json"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    default ResponseEntity<Object> itemGetBoxMarks(@ApiParam(value = "", required = false) @RequestParam(value = "form_type") Integer formType, @ApiParam(value = "", required = false) @RequestParam(value = "work_num") String workNum) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /repeatLabels : 调用存储过程,把获取的数据重复set_num遍
     *
     * @param workNum 编号
     * @return 重复数据的 JSON 格式响应
     */
    @GetMapping("/repeatLabels")
    ResponseEntity<Object> repeatLabels(@RequestParam("work_num") String workNum);

    /**
     * GET /monthWork : 调用存储过程
     *
     * @param date 年月日期
     * @param name 姓名
     * @return 重复数据的 JSON 格式响应
     */
    @GetMapping("/monthWork")
    ResponseEntity<Object> monthWork(@RequestParam("date") String date, @RequestParam("name") String name);

}
