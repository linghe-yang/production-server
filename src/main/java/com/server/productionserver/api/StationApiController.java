package com.server.productionserver.api;
import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.StationDAO;
import com.server.productionserver.model.Production;
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

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-10T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class StationApiController implements StationApi{
    private final NativeWebRequest request;

    @Autowired
    StationDAO stationDAO;

    private boolean deleteFlag;
    private boolean insertFlag;
    private boolean changeFlag;

    @org.springframework.beans.factory.annotation.Autowired
    public StationApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //查询全部记录
    public List<Station> findAllInfo() {
        List<Station> StationList = stationDAO.findAll();
        return StationList;
    }

    //根据id查询记录
    public Optional<Station> findInfoById(String Id) {
        Optional<Station> StationList = stationDAO.findById(Id);
        return StationList;
    }

    //插入记录
    public Station insertInfo(Station station) {
        //先查询记录
        Optional<Station> StationList = stationDAO.findById(station.getid());
        //不存在则插入
        if(StationList.isEmpty()) {
            Station newStation = new Station();
            newStation.setid(station.getid());
            newStation.setname(station.getname());
            Station save = stationDAO.save(newStation);
            return save;
        }
        //数据已存在
        return null;
    }

    //根据id删除记录
    public boolean deleteInfoById(String StationId) {
        //先找
        Optional<Station> StationList = stationDAO.findById(StationId);
        //找不到
        if(StationList.isEmpty()) return false;
        //找到了再删除
        stationDAO.deleteById(StationId);
        return true;

    }

    //根据id修改记录
    public boolean changeInfoById(Station station) {
        //先查询记录
        Optional<Station> StationList = stationDAO.findById(station.getid());
        //不存在
        if(StationList.isEmpty()) return false;
        else {
            Station newStation = new Station();
            newStation.setid(station.getid());
            newStation.setname(station.getname());
            stationDAO.save(newStation);
            return true;
        }
    }

    /**
     * DELETE /reqDelJob : 根据id删除岗位信息
     *
     * @return 成功 (status code 200)
     *      or 找不到记录 (status code 404)
     */
    @ApiOperation(value = "根据id删除岗位信息", nickname = "stationIdDelete", notes = "", response = Object.class, tags={ "岗位表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "找不到记录", response = Object.class)})
    @RequestMapping(value = "/reqDelJob",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> stationIdDelete(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String stationId) {
        String code;
        deleteFlag = deleteInfoById(stationId);
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
     * POST /reqGetJob : 根据id获取岗位信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id获取岗位信息", nickname = "stationIdGet", notes = "", response = Object.class, tags={ "岗位表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetJob",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> stationIdGet(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  String stationId) {
        Optional<Station> stations = findInfoById(stationId);
        String code = "200";

        if(stations.isPresent()) {
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {

                        String exampleString = "{ \"code\" : "+code+", \"data\" : [ ";
                        String objectJson = JSON.toJSONString(stations);
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
     * PUT /reqSetJob : 修改岗位信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "根据id修改岗位信息", nickname = "stationPut", notes = "", response = Object.class, tags={ "岗位表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class),
            @ApiResponse(code = 404, message = "记录不存在", response = Object.class)})
    @RequestMapping(value = "/reqSetJob",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Object> stationPut(@ApiParam(value = "", required=true) @RequestBody Station station) {
        String code;
        changeFlag = changeInfoById(station);
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
     * GET /reqGetAllJob : 查询全部岗位
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询全部岗位", nickname = "stationGet", notes = "", response = Object.class, tags={ "岗位表", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/reqGetAllJob",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Object> boxGet() {
        List<Station> stations = findAllInfo();
        String code = "200";
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : "+code+", \"data\" : ";
                    //类对象转换成json
                    String objectJson = JSON.toJSONString(stations);
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
     * POST /reqAddJob: 插入岗位信息
     *
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "插入岗位信息", nickname = "stationPost", notes = "", response = Object.class, tags={ "岗位表", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "成功", response = Object.class),
            @ApiResponse(code = 403, message = "禁止访问", response = Object.class)
    })
    @RequestMapping(value = "/reqAddJob",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Object> stationPost(@ApiParam(value = "", required=true) @RequestBody Station station) {
        String code;
        Station save = insertInfo(station);
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
