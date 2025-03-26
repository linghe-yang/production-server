package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * packing
 */
@ApiModel(description = "packing")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")


@Entity
//装箱单表
public class Packing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("work_num")
    private String workNum;
    

    @JsonProperty("total_box_num")
    private Integer totalBoxNum;

    @JsonProperty("this_box_num")
    private Integer thisBoxNum;

    @JsonProperty("box")
    private String box;

    public Packing workNum(String workNum) {
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

    public Packing totalBoxNum(Integer totalBoxNum) {
        this.totalBoxNum = totalBoxNum;
        return this;
    }

    /**
     * Get totalBoxNum
     * @return totalBoxNum
     */
    @ApiModelProperty(value = "")
    @Min(1)
    public Integer getTotalBoxNum() {
        return totalBoxNum;
    }

    public void setTotalBoxNum(Integer totalBoxNum) {
        this.totalBoxNum = totalBoxNum;
    }

    public Packing thisBoxNum(Integer thisBoxNum) {
        this.thisBoxNum = thisBoxNum;
        return this;
    }

    /**
     * Get thisBoxNum
     * @return thisBoxNum
     */
    @ApiModelProperty(value = "")
    @Min(1)
    public Integer getThisBoxNum() {
        return thisBoxNum;
    }

    public void setThisBoxNum(Integer thisBoxNum) {
        this.thisBoxNum = thisBoxNum;
    }

    public Packing box(String box) {
        this.box = box;
        return this;
    }

    /**
     * Get box
     * @return box
     */
    @ApiModelProperty(required = false, value = "")


    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Packing packing = (Packing) o;
        return Objects.equals(this.workNum, packing.workNum) &&
                Objects.equals(this.totalBoxNum, packing.totalBoxNum) &&
                Objects.equals(this.thisBoxNum, packing.thisBoxNum) &&
                Objects.equals(this.box, packing.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workNum, totalBoxNum, thisBoxNum, box);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Packing {\n");

        sb.append("    workNum: ").append(toIndentedString(workNum)).append("\n");
        sb.append("    totalBoxNum: ").append(toIndentedString(totalBoxNum)).append("\n");
        sb.append("    thisBoxNum: ").append(toIndentedString(thisBoxNum)).append("\n");
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
