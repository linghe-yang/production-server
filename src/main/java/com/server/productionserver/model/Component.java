package com.server.productionserver.model;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * component
 */
@ApiModel(description = "component")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//component零件表
public class Component   {

    @Id
    @NotBlank
    @JsonProperty("com_id")
    private String comId;

    @JsonProperty("com_num")
    private Integer comNum;

    @JsonProperty("com_count")
    private Integer comCount;

    @JsonProperty("com_order")
    private Integer comOrder;

    @JsonProperty("com_length")
    private Integer comLength;

    @JsonProperty("com_width")
    private Integer comWidth;

    @JsonProperty("com_type")
    private String comType;

    @JsonProperty("com_kind")
    @Max(4)
    @Min(1)
    private Integer comKind;

    @JsonProperty("com_size")
    private Integer comSize;

    @JsonProperty("welding_area")
    private Integer weldingArea;

    @JsonProperty("producing_area")
    private Integer producingArea;

    @JsonProperty("producing_num")
    private Integer producingNum;

    @JsonProperty("box_id")
    private String boxId;

//    //设置时区为上海时区，时间格式自己据需求定。
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JsonProperty("com_time")
//    private Timestamp comTime;

    @JsonProperty("work_id")
    private String workId;

    public Component comId(String comId) {
        this.comId = comId;
        return this;
    }

    /**
     * Get comId
     * @return comId
     */
    @ApiModelProperty(required = true, value = "")
    @NotBlank

    @Size(max=100)
    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public Component comNum(Integer comNum) {
        this.comNum = comNum;
        return this;
    }

    /**
     * Get comNum
     * @return comNum
     */
    @ApiModelProperty(value = "")

    public Integer getComNum() {
        return comNum;
    }

    public void setComNum(Integer comNum) {
        this.comNum = comNum;
    }

    public Component comCount(Integer comCount) {
        this.comCount = comCount;
        return this;
    }

    /**
     * Get comCount
     * minimum: -2147483648
     * maximum: 2147483647
     * @return comCount
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Component comOrder(Integer comOrder) {
        this.comOrder = comOrder;
        return this;
    }

    /**
     * Get comOrder
     * minimum: -2147483648
     * maximum: 2147483647
     * @return comOrder
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getComOrder() {
        return comOrder;
    }

    public void setComOrder(Integer comOrder) {
        this.comOrder = comOrder;
    }

    public Component comLength(Integer comLength) {
        this.comLength = comLength;
        return this;
    }

    /**
     * Get comLength
     * minimum: -2147483648
     * maximum: 2147483647
     * @return comLength
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getComLength() {
        return comLength;
    }

    public void setComLength(Integer comLength) {
        this.comLength = comLength;
    }

    public Component comWidth(Integer comWidth) {
        this.comWidth = comWidth;
        return this;
    }

    /**
     * Get comWidth
     * minimum: -2147483648
     * maximum: 2147483647
     * @return comWidth
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getComWidth() {
        return comWidth;
    }

    public void setComWidth(Integer comWidth) {
        this.comWidth = comWidth;
    }

    public Component comKind(Integer comKind) {
        this.comKind = comKind;
        return this;
    }

    /**
     * Get comKind
     * @return comKind
     */

    @ApiModelProperty(value = "")

    @Min(1) @Max(4)
    public Integer getComKind() {
        return comKind;
    }

    public void setComKind(Integer comKind) {
        this.comKind = comKind;
    }


    public Component comType(String comType) {
        this.comType = comType;
        return this;
    }

    /**
     * Get comType
     * @return comType
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public Component comSize(Integer comSize) {
        this.comSize = comSize;
        return this;
    }

    /**
     * Get comSize
     * minimum: -2147483648
     * maximum: 2147483647
     * @return comSize
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getComSize() {
        return comSize;
    }

    public void setComSize(Integer comSize) {
        this.comSize = comSize;
    }

    public Component weldingArea(Integer weldingArea) {
        this.weldingArea = weldingArea;
        return this;
    }

    /**
     * Get weldingArea
     * minimum: -2147483648
     * maximum: 2147483647
     * @return weldingArea
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getWeldingArea() {
        return weldingArea;
    }

    public void setWeldingArea(Integer weldingArea) {
        this.weldingArea = weldingArea;
    }

    public Component producingArea(Integer producingArea) {
        this.producingArea = producingArea;
        return this;
    }

    /**
     * Get producingArea
     * minimum: -2147483648
     * maximum: 2147483647
     * @return producingArea
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(Integer producingArea) {
        this.producingArea = producingArea;
    }

    public Component producingNum(Integer producingNum) {
        this.producingNum = producingNum;
        return this;
    }

    /**
     * Get producingNum
     * minimum: -2147483648
     * maximum: 2147483647
     * @return producingNum
     */
    @ApiModelProperty(value = "")

    @Min(-2147483648) @Max(2147483647)
    public Integer getProducingNum() {
        return producingNum;
    }

    public void setProducingNum(Integer producingNum) {
        this.producingNum = producingNum;
    }

    public Component boxId(String boxId) {
        this.boxId = boxId;
        return this;
    }

    /**
     * Get boxId
     * @return boxId
     */
    @ApiModelProperty(required = true, value = "")


    public String getboxId() {
        return boxId;
    }

    public void setboxId(String boxId) {
        this.boxId = boxId;
    }

//    public Component comTime(Timestamp comTime) {
//        this.comTime = comTime;
//        return this;
//    }
//    /**
//     * Get comTime
//     * @return comTime
//     */
//    @ApiModelProperty(value = "")
//    public Timestamp getComTime() {
//        return comTime;
//    }
//
//    public void setComTime(Timestamp comTime) {
//        this.comTime = comTime;
//    }

    public Component workId(String workId) {
        this.workId = workId;
        return this;
    }

    /**
     * Get workId
     * @return workId
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Component component = (Component) o;
        return Objects.equals(this.comId, component.comId) &&
                Objects.equals(this.comNum, component.comNum) &&
                Objects.equals(this.comCount, component.comCount) &&
                Objects.equals(this.comOrder, component.comOrder) &&
                Objects.equals(this.comLength, component.comLength) &&
                Objects.equals(this.comWidth, component.comWidth) &&
                Objects.equals(this.comType, component.comType) &&
                Objects.equals(this.comKind, component.comKind) &&
                Objects.equals(this.comSize, component.comSize) &&
                Objects.equals(this.weldingArea, component.weldingArea) &&
                Objects.equals(this.producingArea, component.producingArea) &&
                Objects.equals(this.producingNum, component.producingNum) &&
                Objects.equals(this.boxId, component.boxId) &&
//                Objects.equals(this.comTime, component.comTime) &&
                Objects.equals(this.workId, component.workId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comId, comNum, comCount, comOrder, comLength, comWidth, comType, comKind, weldingArea, producingArea, producingNum, boxId, workId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Component {\n");

        sb.append("    comId: ").append(toIndentedString(comId)).append("\n");
        sb.append("    comNum: ").append(toIndentedString(comNum)).append("\n");
        sb.append("    comCount: ").append(toIndentedString(comCount)).append("\n");
        sb.append("    comOrder: ").append(toIndentedString(comOrder)).append("\n");
        sb.append("    comLength: ").append(toIndentedString(comLength)).append("\n");
        sb.append("    comWidth: ").append(toIndentedString(comWidth)).append("\n");
        sb.append("    comType: ").append(toIndentedString(comType)).append("\n");
        sb.append("    comKind: ").append(toIndentedString(comKind)).append("\n");
        sb.append("    comSize: ").append(toIndentedString(comSize)).append("\n");
        sb.append("    weldingArea: ").append(toIndentedString(weldingArea)).append("\n");
        sb.append("    producingArea: ").append(toIndentedString(producingArea)).append("\n");
        sb.append("    producingNum: ").append(toIndentedString(producingNum)).append("\n");
        sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
//        sb.append("    comTime: ").append(toIndentedString(comTime)).append("\n");
        sb.append("    workId: ").append(toIndentedString(workId)).append("\n");
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

