package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.OddJobsDAO;
import com.server.productionserver.model.OddJobs;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

//杂活备注表
@CrossOrigin(origins = "*")
@Controller
public class OddJobsApiController implements OddJobsApi{
    private final NativeWebRequest request;

    @Autowired
    OddJobsDAO oddJobsDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public OddJobsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    public void insertOddJobs(String date, String stuffName, String other) {
        //在存入数据库表之前，先删除表中date和stuff_name 与传来数据相同的项
        oddJobsDAO.deleteByDateAndStuffName(date, stuffName);
        //然后插入新数据
        OddJobs oddJob = new OddJobs();
        oddJob.setDate(date);
        oddJob.setStuffName(stuffName);
        oddJob.setOther(other);
        oddJobsDAO.save(oddJob);
    }

    public List<OddJobs> findCertainInfo(String beginDate, String endDate) {
        List<OddJobs> allList = oddJobsDAO.findAll();
        List<OddJobs> resultList = new ArrayList<>();
        for(OddJobs job : allList) {
            if(beginDate != null && !beginDate.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate beginTime = LocalDate.parse(beginDate, formatter);
                LocalDate nowTime = LocalDate.parse(job.getDate(), formatter);
                if(nowTime.isBefore(beginTime)) continue;
            }
            if(endDate != null && !endDate.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate endTime = LocalDate.parse(endDate, formatter);
                LocalDate nowTime = LocalDate.parse(job.getDate(), formatter);
                if(nowTime.isAfter(endTime)) continue;
            }
            resultList.add(job);
        }
        return resultList;
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
    public ResponseEntity<Object> oddJobsGet(@ApiParam(value = "", required=false) @RequestParam(value = "begin_date") String beginDate, @ApiParam(value = "", required=false) @RequestParam(value = "end_date") String endDate) {

        List<OddJobs> oddJobsList = findCertainInfo(beginDate, endDate);

        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" :  ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(oddJobsList);
                    exampleString += objectJson;
                    exampleString += " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("查询满足条件记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);
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
    public ResponseEntity<Object> oddJobsPost(@ApiParam(value = "", required=false) @RequestParam(value = "date") String date, @ApiParam(value = "", required=false) @RequestParam(value = "stuff_name") String stuffName, @ApiParam(value = "", required=false) @RequestParam(value = "other") String other) {
        insertOddJobs(date, stuffName, other);
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+200+", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        System.out.println("插入记录请求成功!");
        return new ResponseEntity<>(HttpStatus.CREATED);

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
    public ResponseEntity<Object> oddJobsDelete(@ApiParam(value = "", required=false) @RequestParam(value = "date") String date, @ApiParam(value = "", required=false) @RequestParam(value = "stuff_name") String stuffName) {
        oddJobsDAO.deleteByDateAndStuffName(date, stuffName);
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                    String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                    exampleString += " ]}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });

        System.out.println("删除记录成功！");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
