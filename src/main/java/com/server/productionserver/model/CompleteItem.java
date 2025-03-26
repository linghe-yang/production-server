package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "CompleteItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
//生产量零件表
@Entity
public class CompleteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("work_num")
    private String workNum;

    @JsonProperty("plan_date")
    private String planDate;

    @JsonProperty("staff_name")
    private String staffName;

    @JsonProperty("staff_job")
    private String staffJob;

    @JsonProperty("box")
    private String box;

    @JsonProperty("com_order")
    private String comOrder;

    @JsonProperty("length")
    private String length;

    @JsonProperty("width")
    private String width;

    @JsonProperty("full_length")
    private String fullLength;

    @JsonProperty("num")
    private String num;

    @JsonProperty("spare")
    private String spare;

    @JsonProperty("order_area")
    private String orderArea;

    @JsonProperty("product_area")
    private String productArea;

    @JsonProperty("complete")
    @Min(-1)
    private Integer complete;

    @JsonProperty("sheet_type")
    private String sheetType;


    public CompleteItem id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @ApiModelProperty(required = false, value = "")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompleteItem workNum(String workNum) {
        this.workNum = workNum;
        return this;
    }

    /**
     * Get workNum
     * @return workNum
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public CompleteItem planDate(String planDate) {
        this.planDate = planDate;
        return this;
    }

    /**
     * Get planDate
     * @return planDate
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public CompleteItem staffName(String staffName) {
        this.staffName = staffName;
        return this;
    }

    /**
     * Get staffName
     * @return staffName
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public CompleteItem staffJob(String staffJob) {
        this.staffJob = staffJob;
        return this;
    }

    /**
     * Get staffJob
     * @return staffJob
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getStaffJob() {
        return staffJob;
    }

    public void setStaffJob(String staffJob) {
        this.staffJob = staffJob;
    }

    public CompleteItem box(String box) {
        this.box = box;
        return this;
    }

    /**
     * Get box
     * @return box
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }


    public CompleteItem comOrder(String comOrder) {
        this.comOrder = comOrder;
        return this;
    }

    /**
     * Get comOrder
     * @return comOrder
     */
    @ApiModelProperty(required = true, value = "")

    @Size(max=100)
    public String getComOrder() {
        return comOrder;
    }

    public void setComOrder(String comOrder) {
        this.comOrder = comOrder;
    }



    /**
     * Get length
     * @return length
     */
    @ApiModelProperty(value = "")
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public CompleteItem width(String width) {
        this.width = width;
        return this;
    }

    /**
     * Get width
     * @return width
     */
    @ApiModelProperty(value = "")
    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public CompleteItem fullLength(String fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    /**
     * Get fullLength
     * @return fullLength
     */
    @ApiModelProperty(value = "")
    public String getFullLength() {
        return fullLength;
    }

    public void setFullLength(String fullLength) {
        this.fullLength = fullLength;
    }

    public CompleteItem num(String num) {
        this.num = num;
        return this;
    }

    /**
     * Get num
     * @return num
     */
    @ApiModelProperty(value = "")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }




    public CompleteItem spare(String spare) {
        this.spare = spare;
        return this;
    }

    /**
     * Get spare
     * @return spare
     */
    @ApiModelProperty(value = "")

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }



    public CompleteItem orderArea(String orderArea) {
        this.orderArea = orderArea;
        return this;
    }

    /**
     * Get orderArea
     * @return orderArea
     */
    @ApiModelProperty(value = "")
    public String getOrderArea() {
        return orderArea;
    }

    public void setOrderArea(String orderArea) {
        this.orderArea = orderArea;
    }




    public CompleteItem productArea(String productArea) {
        this.productArea = productArea;
        return this;
    }

    /**
     * Get productArea
     * @return productArea
     */
    @ApiModelProperty(value = "")
    public String getProductArea() {
        return productArea;
    }
    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }




    public CompleteItem complete(Integer complete) {
        this.complete = complete;
        return this;
    }

    /**
     * Get complete
     * @return complete
     */
    @ApiModelProperty(value = "")
    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }


    public CompleteItem sheetType(String sheetType) {
        this.sheetType = sheetType;
        return this;
    }

    /**
     * Get sheetType
     * @return sheetType
     */
    @ApiModelProperty(value = "")
    public String getSheetType() {
        return sheetType;
    }
    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompleteItem CompleteItem = (CompleteItem) o;
        return Objects.equals(this.id, CompleteItem.id) &&
                Objects.equals(this.workNum, CompleteItem.workNum) &&
                Objects.equals(this.planDate, CompleteItem.planDate) &&
                Objects.equals(this.staffName, CompleteItem.staffName) &&
                Objects.equals(this.staffJob, CompleteItem.staffJob) &&
                Objects.equals(this.box, CompleteItem.box) &&
                Objects.equals(this.comOrder, CompleteItem.comOrder) &&
                Objects.equals(this.length, CompleteItem.length) &&
                Objects.equals(this.width, CompleteItem.width) &&
                Objects.equals(this.fullLength, CompleteItem.fullLength) &&
                Objects.equals(this.num, CompleteItem.num) &&
                Objects.equals(this.spare, CompleteItem.spare) &&
                Objects.equals(this.orderArea, CompleteItem.orderArea) &&
                Objects.equals(this.productArea, CompleteItem.productArea) &&
                Objects.equals(this.complete, CompleteItem.complete) &&
                Objects.equals(this.sheetType, CompleteItem.sheetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workNum, planDate, staffName, staffJob, box, comOrder, length, width, fullLength, num, spare, orderArea, productArea, complete, sheetType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CompleteItem {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    workNum: ").append(toIndentedString(workNum)).append("\n");
        sb.append("    planDate: ").append(toIndentedString(planDate)).append("\n");
        sb.append("    staffName: ").append(toIndentedString(staffName)).append("\n");
        sb.append("    staffJob: ").append(toIndentedString(staffJob)).append("\n");
        sb.append("    box: ").append(toIndentedString(box)).append("\n");
        sb.append("    comOrder: ").append(toIndentedString(comOrder)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
        sb.append("    fullLength: ").append(toIndentedString(fullLength)).append("\n");
        sb.append("    num: ").append(toIndentedString(num)).append("\n");
        sb.append("    spare: ").append(toIndentedString(spare)).append("\n");
        sb.append("    orderArea: ").append(toIndentedString(orderArea)).append("\n");
        sb.append("    productArea: ").append(toIndentedString(productArea)).append("\n");
        sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
        sb.append("    sheetType: ").append(toIndentedString(sheetType)).append("\n");
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
