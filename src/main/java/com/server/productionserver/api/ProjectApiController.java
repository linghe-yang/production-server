package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ProjectDAO;
import com.server.productionserver.model.*;
import io.swagger.annotations.ApiOperation;
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


import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopy.base-path:/}")
public class ProjectApiController implements ProjectApi {

    @Autowired
    ProjectDAO projectDAO;

    private final NativeWebRequest request;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;
    private boolean finishFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public ProjectApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Project> findAllInfo() {
        List<Project> projectList = projectDAO.findAll();
        return projectList;
    }

    //根据id查询记录
    public Optional<Project> findInfoById(String Id) {
        Optional<Project> project = projectDAO.findById(Id);
        return project;
    }

    //插入记录
    public Project insertInfo(Project project) {
        //先查询记录
        Optional<Project> projectList = projectDAO.findById(project.getid());
        //不存在则插入
        if(projectList.isEmpty()) {
            Project newProject = new Project();
            newProject.setid(project.getid());
            newProject.setname(project.getname());
            newProject.setfinish(project.getfinish());
            Project save = projectDAO.save(newProject);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String projectId) {
        //先找
        Optional<Project> projectList = projectDAO.findById(projectId);
        //找不到
        if(projectList.isEmpty()) return false;
        //找到了再删除
        projectDAO.deleteById(projectId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(Project project) {
        //先查询记录
        Optional<Project> projectList = projectDAO.findById(project.getid());
        //不存在
        if(projectList.isEmpty()) return false;
        else {
            Project newProject = new Project();
            newProject.setid(project.getid());
            newProject.setname(project.getname());
            newProject.setfinish(0);
            projectDAO.save(newProject);
            return true;
        }
    }

    //根据id完成记录
    public boolean finishInfoById(Project project) {
        //先查询记录
        Optional<Project> projectList = projectDAO.findById(project.getid());
        //不存在
        if(projectList.isEmpty()) return false;
        else {
            Project project1 = projectList.get();
            Project newProject = new Project();
            newProject.setid(project1.getid());
            newProject.setname(project1.getname());
            newProject.setfinish(1);
            projectDAO.save(newProject);
            return true;
        }
    }


    /**
     * GET /reqGetAllProject : 查询全部项目
     *
     * @return 成功 (status code 200)
     */
    @Override
    @ApiOperation(value = "查询全部项目", nickname = "projectGet", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllProject",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Project>> projectGet() {

        List<Project> projects = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(projects);
                    exampleString += objectJson;
                    exampleString += "}";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        System.out.println("查询所有记录请求成功!");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * POST /reqGetProject : 根据id获取项目记录
     *
     * @param projectId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取项目记录", nickname = "projectIdGet", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetProject",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> projectIdGet(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String projectId) {

        Optional<Project> project = findInfoById(projectId);
        String code = "200";

        if(project.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(project);
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

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        exampleString += " ]}";

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
     * POST /reqAddProject : 插入项目记录
     *
     * @param projectId  (required)
     * @param projectName  (optional)
     * @return 成功 (status code 201)
     *         or 禁止访问 (status code 403)
     */
    @ApiOperation(value = "插入项目记录", nickname = "projectPost", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "禁止访问", response = Object.class)})
    @RequestMapping(value = "/reqAddProject",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> projectPost(@ApiParam(value = "", required=true) @RequestBody Project project) {

        String code;
        Project save = insertInfo(project);
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


    /**
     * DELETE /reqDelProject : 根据id删除项目记录
     *
     * @param projectId  (required)
     * @param projectName  (optional)
     * @return 成功 (status code 200)
     *         or 记录不存在 (status code 404)
     */
    @ApiOperation(value = "根据id删除项目记录", nickname = "projectIdDelete", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
    @RequestMapping(value = "/reqDelProject",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> projectIdDelete(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String projectId) {
        String code;
        deleteFlag = deleteInfoById(projectId);
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
     * PUT /reqSetProject : 根据id修改项目信息
     *
     * @return 成功 (status code 200)
     *         or 记录不存在 (status code 404)
     */
    @ApiOperation(value = "根据id修改项目信息", nickname = "projectPut", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
    @RequestMapping(value = "/reqSetProject",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> projectPut(@ApiParam(value = "", required=true) @RequestBody Project project) {
            String code;

            changeFlag = changeInfoById(project);
            if(changeFlag) {
                code = "200";
                getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "通过id修改数据成功!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("通过id修改数据成功！");
            return new ResponseEntity<>(HttpStatus.OK);

            } else {
                code = "404";
                getRequest().ifPresent(request -> {
                    for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                            String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                            String result = "修改失败！数据不存在!";
                            exampleString += result;
                            exampleString += " \"}";
                            ApiUtil.setExampleResponse(request, "application/json", exampleString);
                            break;
                        }
                    }
                });
                System.out.println("修改失败！数据不存在！");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    /**
     * PUT /reqFinishProject : 完成项目
     *
     * @return 成功 (status code 200)
     *         or 记录不存在 (status code 404)
     */
    @ApiOperation(value = "根据id修改项目信息", nickname = "projectPut", notes = "", response = Object.class, tags={ "项目表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class) })
    @RequestMapping(value = "/reqFinishProject",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> projectFinnishPut(@ApiParam(value = "", required=true) @RequestBody Project project) {
        String code;

        finishFlag = finishInfoById(project);
        if(finishFlag) {
            code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "修改数据成功!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("修改数据成功！");
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            code = "404";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "修改失败！数据不存在!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("修改失败！数据不存在！");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
