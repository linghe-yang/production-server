package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "image")
@Entity
//logo图片表
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("path")
    private String path;

//    @JsonProperty("cus_id")
//    private String cusId;

    public Image id(Long id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image path(String path) {
        this.path = path;
        return this;
    }

    @ApiModelProperty(value = "")
    public String getPath() {
        return path;
    }

    public void setPath(String data) {
        this.path = path;
    }

//    public Image cusId(String cusId) {
//        this.cusId = cusId;
//        return this;
//    }
//
//    @ApiModelProperty(value = "")
//    public String getCusId() {
//        return cusId;
//    }
//
//    public void setCusId(String cusId) {
//        this.cusId = cusId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(path, image.path);
//                Objects.equals(cusId, image.cusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Image {\n");
        sb.append("    id: ").append(id).append("\n");
        sb.append("    path: ").append(path).append("\n");
//        sb.append("    cusId: ").append(data).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
