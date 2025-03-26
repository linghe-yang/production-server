package com.server.productionserver.api;

import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.StaffDAO;
import com.server.productionserver.model.OrganizationRequirements;
import com.server.productionserver.model.PackageRequirements;
import com.server.productionserver.model.Staff;
import com.server.productionserver.model.Station;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class StaffApiController implements StaffApi {

    private final NativeWebRequest request;

    @Autowired
    StaffDAO staffDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;



    @org.springframework.beans.factory.annotation.Autowired
    public StaffApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Staff> findAllInfo() {
        List<Staff> StaffList = staffDAO.findAll();
        return StaffList;
    }

    //根据id查询记录
    public Optional<Staff> findInfoById(String id) {
        Optional<Staff> staffs = staffDAO.findById(id);
        return staffs;
    }

    //插入记录
    public Staff insertInfo(Staff staff) {
        //先查询记录
        Optional<Staff> StaffList = staffDAO.findById(staff.getid());
        //不存在则插入
        if(StaffList.isEmpty()) {
            Staff newStaff = new Staff();
            newStaff.setid(staff.getid());
            newStaff.setDuty(staff.getDuty());
            newStaff.setname(staff.getname());
            newStaff.setpassword(staff.getpassword());
            newStaff.setphone(staff.getphone());
            Staff save = staffDAO.save(newStaff);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String StaffId) {
        //先找
        Optional<Staff> StaffList = staffDAO.findById(StaffId);
        //找不到
        if(StaffList.isEmpty()) return false;
        //找到了再删除
        staffDAO.deleteById(StaffId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(Staff staff) {
        //先查询记录
        Optional<Staff> StaffList = staffDAO.findById(staff.getid());
        //不存在
        if (StaffList.isEmpty()) return false;
        else {
            Staff newStaff = new Staff();
            newStaff.setid(staff.getid());
            newStaff.setDuty(staff.getDuty());
            newStaff.setname(staff.getname());
            newStaff.setpassword(staff.getpassword());
            newStaff.setphone(staff.getphone());
            Staff save = staffDAO.save(newStaff);
            staffDAO.save(newStaff);
            return true;
        }

    }

    /**
     * GET /reqGetAllStaff : 查询全部员工信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部员工信息", nickname = "staffGet", notes = "", response = Object.class, tags={ "员工表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllStaff",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> staffGet() {
        List<Staff> staffs = findAllInfo();
        String code = "200";

        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(staffs);
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
     * POST /reqAddStaff : 插入员工信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入员工信息", nickname = "staffPost", notes = "", response = Object.class, tags={ "员工表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqAddStaff",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> staffPost(@ApiParam(value = "", required=true) @RequestBody Staff staff) {
        String code;
        Staff save = insertInfo(staff);
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
     * DELETE /reqDelStaff : 根据id删除员工信息
     *
     * @param staffId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id删除员工信息", nickname = "staffStaffIdDelete", notes = "", response = Object.class, tags={ "员工表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqDelStaff",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> staffStaffIdDelete(@ApiParam(value = "",required=true) @RequestParam("id") String id) {
        String code;
        deleteFlag = deleteInfoById(id);
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
     * POST /reqGetStaff : 根据id获取员工信息
     *
     * @param staffId  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取员工信息", nickname = "staffStaffIdGet", notes = "", response = Object.class, tags={ "员工表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetStaff",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> staffStaffIdGet(@ApiParam(value = "") @RequestParam("id") String id) {
        Optional<Staff> staffs = findInfoById(id);
        String code = "200";

        if(staffs.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [";
                        String objectJson = JSON.toJSONString(staffs);
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

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [";
                        exampleString += "]}";

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
     * PUT /reqSetStaff : 修改员工信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改员工信息", nickname = "staffStaffIdPut", notes = "", response = Object.class, tags={ "员工表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqSetStaff",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> staffStaffIdPut(@ApiParam(value = "", required=true) @RequestBody Staff staff) {
        String code;

        changeFlag = changeInfoById(staff);
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



}
