package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "Item")

//报表零件表
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("com_order")
    private String comOrder;

    @JsonProperty("type")
    private String type;

    @JsonProperty("length")
    private String length;

    @JsonProperty("width")
    private String width;

    @JsonProperty("num")
    private String num;

    @JsonProperty("cut_length")
    private String cutLength;

    @JsonProperty("cut_width")
    private String cutWidth;

    @JsonProperty("form_type")
    @Max(4)
    @Min(1)
    private Integer formType;

    @JsonProperty("count")
    private String count;

    @JsonProperty("spare")
    private String spare;

    @JsonProperty("full_length")
    private String fullLength;

    @JsonProperty("order_area")
    private String orderArea;

    @JsonProperty("product_area")
    private String productArea;

    @JsonProperty("house_type")
    private String houseType;

    @JsonProperty("position")
    private String position;

    @JsonProperty("box")
    private String box;

    @JsonProperty("work_num")
    private String workNum;

    @JsonProperty("complete")
    @Min(-1)
    private Integer complete;

    public Item id(Long id) {
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


    public Item comOrder(String comOrder) {
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

    public Item type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     */
    @ApiModelProperty(value = "")

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item length(String length) {
        this.length = length;
        return this;
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

    public Item width(String width) {
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

    public Item num(String num) {
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

    public Item cutLength(String cutLength) {
        this.cutLength = cutLength;
        return this;
    }

    /**
     * Get cutLength
     * @return cutLength
     */
    @ApiModelProperty(value = "")

    public String getCutLength() {
        return cutLength;
    }

    public void setCutLength(String cutLength) {
        this.cutLength = cutLength;
    }

    public Item formType(Integer formType) {
        this.formType = formType;
        return this;
    }

    /**
     * Get formType
     * @return formType
     */

    @ApiModelProperty(value = "")

    //四种报表类型
    @Min(1) @Max(4)
    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }


    public Item cutWidth(String cutWidth) {
        this.cutWidth = cutWidth;
        return this;
    }

    /**
     * Get cutWidth
     * @return cutWidth
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getCutWidth() {
        return cutWidth;
    }

    public void setCutWidth(String cutWidth) {
        this.cutWidth = cutWidth;
    }

    public Item count(String count) {
        this.count = count;
        return this;
    }

    /**
     * Get count
     * @return count
     */
    @ApiModelProperty(value = "")

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Item spare(String spare) {
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

    public Item fullLength(String fullLength) {
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

    public Item orderArea(String orderArea) {
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

    public Item productArea(String productArea) {
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

    public Item houseType(String houseType) {
        this.houseType = houseType;
        return this;
    }
    /**
     * Get houseType
     * @return houseType
     */
    @ApiModelProperty(value = "")
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    public Item position(String position) {
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

    public Item box(String box) {
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

    public Item workNum(String workNum) {
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

    public Item complete(Integer complete) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item Item = (Item) o;
        return Objects.equals(this.id, Item.id) &&
                Objects.equals(this.comOrder, Item.comOrder) &&
                Objects.equals(this.type, Item.type) &&
                Objects.equals(this.length, Item.length) &&
                Objects.equals(this.width, Item.width) &&
                Objects.equals(this.num, Item.num) &&
                Objects.equals(this.cutLength, Item.cutLength) &&
                Objects.equals(this.cutWidth, Item.cutWidth) &&
                Objects.equals(this.formType, Item.formType) &&
                Objects.equals(this.count, Item.count) &&
                Objects.equals(this.spare, Item.spare) &&
                Objects.equals(this.fullLength, Item.fullLength) &&
                Objects.equals(this.orderArea, Item.orderArea) &&
                Objects.equals(this.productArea, Item.productArea) &&
                Objects.equals(this.houseType, Item.houseType) &&
                Objects.equals(this.position, Item.position) &&
                Objects.equals(this.box, Item.box) &&
                Objects.equals(this.workNum, Item.workNum) &&
                Objects.equals(this.complete, Item.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, type, length, width, num, cutLength, cutWidth, formType, spare, fullLength, orderArea, productArea, position, box, workNum, complete);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    comOrder: ").append(toIndentedString(comOrder)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
        sb.append("    num: ").append(toIndentedString(num)).append("\n");
        sb.append("    cutLength: ").append(toIndentedString(cutLength)).append("\n");
        sb.append("    cutWidth: ").append(toIndentedString(cutWidth)).append("\n");
        sb.append("    formType: ").append(toIndentedString(formType)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    spare: ").append(toIndentedString(spare)).append("\n");
        sb.append("    fullLength: ").append(toIndentedString(fullLength)).append("\n");
        sb.append("    orderArea: ").append(toIndentedString(orderArea)).append("\n");
        sb.append("    productArea: ").append(toIndentedString(productArea)).append("\n");
        sb.append("    houseType: ").append(toIndentedString(houseType)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    box: ").append(toIndentedString(box)).append("\n");
        sb.append("    workNum: ").append(toIndentedString(workNum)).append("\n");
        sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
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
