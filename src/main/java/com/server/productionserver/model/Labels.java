package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
/**
 * labels
 */
@ApiModel(description = "labels")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")


@Entity
public class Labels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("work_num")
    private String workNum;

    @JsonProperty("type")
    private String type;

    @JsonProperty("length")
    private String length;

    @JsonProperty("width")
    private String width;

    @JsonProperty("position")
    private String position;

    @JsonProperty("box")
    private String box;

    public Labels workNum(String workNum) {
        this.workNum = workNum;
        return this;
    }

    /**
     * Get workNum
     * @return workNum
     */
    @ApiModelProperty(required = false, value = "")
    @Size(max=100)

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public Labels type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Labels length(String length) {
        this.length = length;
        return this;
    }

    /**
     * Get length
     * @return length
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Labels width(String width) {
        this.width = width;
        return this;
    }

    /**
     * Get width
     * @return width
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Labels position(String position) {
        this.position = position;
        return this;
    }

    /**
     * Get position
     * @return position
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Labels box(String box) {
        this.box = box;
        return this;
    }
    /**
     * Get box
     * @return box
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getBox() { return box; }
    public void setBox(String box) { this.box = box; }




    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Labels labels = (Labels) o;
        return Objects.equals(this.workNum, labels.workNum) &&
                Objects.equals(this.type, labels.type) &&
                Objects.equals(this.length, labels.length) &&
                Objects.equals(this.width, labels.width) &&
                Objects.equals(this.position, labels.position) &&
                Objects.equals(this.box, labels.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workNum, type, length, width, position, box);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Labels {\n");

        sb.append("    workNum: ").append(toIndentedString(workNum)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    box: ").append(toIndentedString(box)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
