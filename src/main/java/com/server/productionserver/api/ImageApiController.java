package com.server.productionserver.api;


import com.alibaba.fastjson2.JSON;
import com.server.productionserver.DAO.ImageDAO;
import com.server.productionserver.model.Image;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T17:21:33.341303800+08:00[Asia/Shanghai]")

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("${openapi.productionManagerCopyCopy.base-path:/}")
public class ImageApiController implements ImageApi {
    private final NativeWebRequest request;


    @Autowired
    ImageDAO imageDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public ImageApiController(NativeWebRequest request) {
        this.request = request;
    }
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //格式化生成唯一文件名
    public static String generateRandomFileName() {
        // 1. 获取当前时间戳
        long timeStamp = System.currentTimeMillis();

        // 2. 格式化时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        String formattedTimeStamp = dateFormat.format(new Date(timeStamp));

        // 3. 生成随机字符
        String randomChars = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);

        // 4. 组合时间戳和随机字符
        String randomFileName = formattedTimeStamp + "_" + randomChars + ".jpg";

        return randomFileName;
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
    public ResponseEntity<Object> uploadLogo(@ApiParam(value = "", required=true) @RequestParam("file") MultipartFile file) {

        String directory = "/root/server/images/";
        String fileName = generateRandomFileName();
        String filePath = directory+fileName;

        System.out.println(filePath);
        // 保存文件到服务器目录
        try (OutputStream os = new FileOutputStream(filePath)) {
            os.write(file.getBytes());
            //图片URL存入数据库
            Image newImage = new Image();
            newImage.setPath(filePath);
            imageDAO.save(newImage);

            String code = "200";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \"";
                        String result = filePath;
                        exampleString += result;
                        exampleString += "\"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("上传图片成功!");
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (IOException e) {
            // 处理异常
            String code = "403";
            getRequest().ifPresent(request -> {
                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                        String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
                        String result = "上传图片失败!";
                        exampleString += result;
                        exampleString += " \"}";
                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
                        break;
                    }
                }
            });
            System.out.println("上传图片失败!");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

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
//    public ResponseEntity<Object> downloadLogo(@ApiParam(value = "", required=true) @RequestParam(value = "cus_id") String cusId) {
//        List<Image> images = imageDAO.findByCusId(cusId);
//
//        if (!images.isEmpty()) {
//            List<Image> downloadedImages = new ArrayList<>();
//
//            for (Image image : images) {
//                Image downloadedImage = new Image();
//                downloadedImage.setId(image.getId());
//                downloadedImage.setData(image.getData());
//                downloadedImage.setCusId(image.getCusId());
//                downloadedImages.add(downloadedImage);
//            }
//            String code = "200";
//            getRequest().ifPresent(request -> {
//                for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
//                    if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
//                        String exampleString = "{ \"code\" : \" "+code+" \" , \"data\" : [";
//                        String objectJson = "";
//                        //image对象转json
//                        for(int i = 0; i <downloadedImages.size();i++) {
//                            Image image = downloadedImages.get(i);
//                            objectJson += "{ \"id\" :";
//                            objectJson += JSON.toJSONString(image.getId());
//                            objectJson += ",";
//                            objectJson += " \"cusId\" :";
//                            objectJson += JSON.toJSONString(image.getCusId());
//                            objectJson += ",";
//                            objectJson += " \"data\" : \" ";
//                            objectJson += JSON.toJSONString(image.getData());
//                            if(i == downloadedImages.size() - 1) objectJson += "\" }";
//                            else objectJson += "\" },";
//                        }
//                        exampleString += objectJson;
//                        exampleString += "]}";
//                        ApiUtil.setExampleResponse(request, "application/json", exampleString);
//                        break;
//                    }
//                }
//            });
//            System.out.println("下载图片成功!");
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        //列表为空
//        String code = "404";
//        getRequest().ifPresent(request -> {
//            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
//                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
//                    String exampleString = "{ \"code\" : "+code+", \"result\" : \" ";
//                    String result = "图片不存在!";
//                    exampleString += result;
//                    exampleString += " \"}";
//                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
//                    break;
//                }
//            }
//        });
//        System.out.println("图片不存在!");
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//
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
//    public ResponseEntity<Object> deleteLogo(@ApiParam(value = "",required=true) @RequestParam("cus_id") String cusId) {
//        imageDAO.deleteByCusId(cusId);
//        String code = "200";
//        getRequest().ifPresent(request -> {
//            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
//                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
//                    String exampleString = "{ \"code\" : \" "+code+" \" , \"result\" : \" ";
//                    String result = "删除记录成功!";
//                    exampleString += result;
//                    exampleString += " \"}";
//                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
//                    break;
//                }
//            }
//
//        });
//
//        System.out.println("删除记录成功！");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
