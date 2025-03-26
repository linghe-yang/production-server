package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.LargeProjectDAO;
import com.server.productionserver.model.Box;
import com.server.productionserver.model.LargeProject;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * @version 1.0
 * @auther Ethan
 */
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class LargeProjectApiController implements LargeProjectApi {
    private final NativeWebRequest request;

    @Autowired
    LargeProjectDAO largeProjectDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public LargeProjectApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }



    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    //插入记录
    public LargeProject insertInfo(LargeProject largeProject) {
        //先查询记录
        Optional<LargeProject> LargeProjectList = largeProjectDAO.findById(largeProject.getProjectName());
        //不存在则插入
        if(LargeProjectList.isEmpty()) {
            LargeProject newLargeProject = new LargeProject();
            newLargeProject.setReceiver(largeProject.getReceiver());
            newLargeProject.setAddress(largeProject.getAddress());
            newLargeProject.setProjectName(largeProject.getProjectName());
            newLargeProject.setReceiveObj(largeProject.getReceiveObj());
            LargeProject save = largeProjectDAO.save(newLargeProject);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoByPK(String projectName) {
        //先找
        Optional<LargeProject> LargeProjectList = largeProjectDAO.findById(projectName);
        //找不到
        if(LargeProjectList.isEmpty()) return false;
        //找到了再删除
        largeProjectDAO.deleteById(projectName);
        return true;

    }

    //根据id查询记录
    public Optional<LargeProject> findInfoByPK(String projectName) {
        Optional<LargeProject> LargeProjectList = largeProjectDAO.findById(projectName);
        return LargeProjectList;
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
    public ResponseEntity<Object> largeProjectDelete(@ApiParam(value = "", required = true) @RequestParam("project_name") String projectName) {
        String code;
        deleteFlag = deleteInfoByPK(projectName);
        if(deleteFlag) {//删除成功
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "根据id删除记录成功!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }

            });

            System.out.println("根据id删除记录成功！");
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            code = "404";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "根据id删除记录失败！记录不存在!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }

            });
            System.out.println("根据id删除记录失败！记录不存在!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
    public ResponseEntity<Object> largeProjectGet(@ApiParam(value = "", required = true) @RequestParam("project_name") String projectName) {
        Optional<LargeProject> largeProjects = findInfoByPK(projectName);
        String code = "200";

        if(largeProjects.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(largeProjects);
                        exampleString += objectJson;
                        exampleString += " ]}";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据id查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : null";
                        exampleString += "}";

                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });

            System.out.println("根据id查询记录请求成功!");
            return new ResponseEntity<>(HttpStatus.OK);
        }

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
    public ResponseEntity<Object> largeProjectEnter(@ApiParam(value = "", required=true) @RequestBody LargeProject largeProject) {
        String code;
        LargeProject save = insertInfo(largeProject);
        if(save == null) {//数据已存在
            insertFlag = false;
            code = "403";//禁止访问，数据已存在
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "插入记录请求失败!记录已存在!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("插入记录请求失败!记录已存在!");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        } else {//save成功
            insertFlag = true;
            code = "201";//创建数据成功
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "插入记录请求成功!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("插入记录请求成功!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }
}
