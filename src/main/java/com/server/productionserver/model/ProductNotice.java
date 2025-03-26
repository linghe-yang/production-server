package com.server.productionserver.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * productNotice
 */
@ApiModel(description = "productNotice")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//生产通知单
public class ProductNotice   {

    @Id
    @NotBlank
    @JsonProperty("work_num")
    private String workNum;

    @JsonProperty("order_time")
    private String orderTime;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("set_num")
    private String setNum;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("contract_num")
    private String contractNum;

    @JsonProperty("enter_date")
    private String enterDate;

    @JsonProperty("order_date")
    private String orderDate;

    @JsonProperty("organ_require")
    private String organRequire;

    @JsonProperty("check_report_num")
    private String checkReportNum;

    @JsonProperty("credential_num")
    private String credentialNum;

    @JsonProperty("receipt_num")
    private String receiptNum;

    @JsonProperty("other")
    private String other;

    @JsonProperty("pack_demand")
    private String packDemand;

    @JsonProperty("orientation")
    private String orientation;

    @JsonProperty("express_company")
    private String expressCompany;

    @JsonProperty("express_num")
    private String expressNum;

    @JsonProperty("enter_staff")
    private String enterStaff;

    @JsonProperty("total_num")
    private String totalNum;

    @JsonProperty("total_product_num")
    private String totalProductNum;

    @JsonProperty("total_length")
    private String totalLength;

    @JsonProperty("total_area")
    private String totalArea;

    @JsonProperty("total_product_area")
    private String totalProductArea;


    public ProductNotice workNum(String workNum) {
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


    public ProductNotice orderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    /**
     * Get orderTime
     * @return orderTime
     */
    @ApiModelProperty(value = "")


    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public ProductNotice itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    /**
     * Get itemName
     * @return itemName
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ProductNotice setNum(String setNum) {
        this.setNum = setNum;
        return this;
    }

    /**
     * Get setNum
     * @return setNum
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }

    public ProductNotice projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    /**
     * Get projectName
     * @return projectName
     */
    @ApiModelProperty(value = "")


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProductNotice customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * Get customerName
     * @return customerName
     */
    @ApiModelProperty(value = "")


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ProductNotice contractNum(String contractNum) {
        this.contractNum = contractNum;
        return this;
    }

    /**
     * Get contractNum
     * @return contractNum
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public ProductNotice enterDate(String enterDate) {
        this.enterDate = enterDate;
        return this;
    }
    /**
     * Get enterDate
     * @return enterDate
     */

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public ProductNotice orderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }
    /**
     * Get orderDate
     * @return orderDate
     */

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public ProductNotice organRequire(String organRequire) {
        this.organRequire = organRequire;
        return this;
    }
    /**
     * Get organRequire
     * @return organRequire
     */
    public String getOrganRequire() {
        return organRequire;
    }

    public void setOrganRequire(String organRequire) {
        this.organRequire = organRequire;
    }


    public ProductNotice checkReportNum(String checkReportNum) {
        this.checkReportNum = checkReportNum;
        return this;
    }
    /**
     * Get checkReportNum
     * @return checkReportNum
     */
    public String getCheckReportNum() {
        return checkReportNum;
    }

    public void setCheckReportNum(String checkReportNum) {
        this.checkReportNum = checkReportNum;
    }
    public ProductNotice credentialNum(String credentialNum) {
        this.credentialNum = credentialNum;
        return this;
    }
    /**
     * Get credentialNum
     * @return credentialNum
     */
    public String getCredentialNum() {
        return credentialNum;
    }

    public void setCredentialNum(String credentialNum) {
        this.credentialNum = credentialNum;
    }
    public ProductNotice receiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
        return this;
    }
    /**
     * Get receiptNum
     * @return receiptNum
     */
    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }
    public ProductNotice other(String other) {
        this.other = other;
        return this;
    }
    /**
     * Get other
     * @return other
     */
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    public ProductNotice packDemand(String packDemand) {
        this.packDemand = packDemand;
        return this;
    }
    /**
     * Get packDemand
     * @return packDemand
     */
    public String getPackDemand() {
        return packDemand;
    }

    public void setPackDemand(String packDemand) {
        this.packDemand = packDemand;
    }

    public ProductNotice orientation(String orientation) {
        this.orientation = orientation;
        return this;
    }
    /**
     * Get orientation
     * @return orientation
     */
    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    public ProductNotice expressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
        return this;
    }
    /**
     * Get expressCompany
     * @return expressCompany
     */
    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }
    public ProductNotice expressNum(String expressNum) {
        this.expressNum = expressNum;
        return this;
    }
    /**
     * Get expressNum
     * @return expressNum
     */
    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }


    public ProductNotice enterStaff(String enterStaff) {
        this.enterStaff = enterStaff;
        return this;
    }
    /**
     * Get enterStaff
     * @return enterStaff
     */
    public String getEnterStaff() {
        return enterStaff;
    }

    public void setEnterStaff(String enterStaff) {
        this.enterStaff = enterStaff;
    }


    public ProductNotice totalNum(String totalNum) {
        this.totalNum = totalNum;
        return this;
    }
    /**
     * Get totalNum
     * @return totalNum
     */
    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }


    public ProductNotice totalProductNum(String totalProductNum) {
        this.totalProductNum = totalProductNum;
        return this;
    }
    /**
     * Get totalProductNum
     * @return totalProductNum
     */
    public String getTotalProductNum() {
        return totalProductNum;
    }

    public void setTotalProductNum(String totalProductNum) {
        this.totalProductNum = totalProductNum;
    }




    public ProductNotice totalLength(String totalLength) {
        this.totalLength = totalLength;
        return this;
    }
    /**
     * Get totalLength
     * @return totalLength
     */
    public String getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(String totalLength) {
        this.totalLength = totalLength;
    }




    public ProductNotice totalArea(String totalArea) {
        this.totalArea = totalArea;
        return this;
    }
    /**
     * Get totalArea
     * @return totalArea
     */
    public String getTotalArea() { return totalArea; }

    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }




    public ProductNotice totalProductArea(String totalProductArea) {
        this.totalProductArea = totalProductArea;
        return this;
    }
    /**
     * Get totalProductArea
     * @return totalProductArea
     */
    public String getTotalProductArea() {
        return totalProductArea;
    }

    public void setTotalProductArea(String totalProductArea) {
        this.totalProductArea = totalProductArea;
    }




    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductNotice productNotice = (ProductNotice) o;
        return Objects.equals(this.workNum, productNotice.workNum) &&
                Objects.equals(this.orderTime, productNotice.orderTime) &&
                Objects.equals(this.itemName, productNotice.itemName) &&
                Objects.equals(this.setNum, productNotice.setNum) &&
                Objects.equals(this.projectName, productNotice.projectName) &&
                Objects.equals(this.customerName, productNotice.customerName) &&
                Objects.equals(this.contractNum, productNotice.contractNum) &&
                Objects.equals(this.enterDate, productNotice.enterDate) &&
                Objects.equals(this.orderDate, productNotice.orderDate) &&
                Objects.equals(this.organRequire, productNotice.organRequire) &&
                Objects.equals(this.checkReportNum, productNotice.checkReportNum) &&
                Objects.equals(this.credentialNum, productNotice.credentialNum) &&
                Objects.equals(this.receiptNum, productNotice.receiptNum) &&
                Objects.equals(this.other, productNotice.other) &&
                Objects.equals(this.packDemand, productNotice.packDemand) &&
                Objects.equals(this.orientation, productNotice.orientation) &&
                Objects.equals(this.expressCompany, productNotice.expressCompany) &&
                Objects.equals(this.expressNum, productNotice.expressNum) &&
                Objects.equals(this.enterStaff, productNotice.enterStaff) &&
                Objects.equals(this.totalNum, productNotice.totalNum) &&
                Objects.equals(this.totalProductNum, productNotice.totalProductNum) &&
                Objects.equals(this.totalLength, productNotice.totalLength) &&
                Objects.equals(this.totalArea, productNotice.totalArea) &&
                Objects.equals(this.totalProductArea, productNotice.totalProductArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workNum, orderTime,  setNum, projectName, customerName, contractNum, enterDate, itemName, orderDate, organRequire, checkReportNum, credentialNum, receiptNum, other, packDemand, orientation, expressCompany, expressNum, enterStaff, totalNum, totalProductNum, totalLength, totalArea, totalProductArea);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductNotice {\n");
        sb.append("    workNum: ").append(toIndentedString(workNum)).append("\n");
        sb.append("    orderTime: ").append(toIndentedString(orderTime)).append("\n");
        sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
        sb.append("    setNum: ").append(toIndentedString(setNum)).append("\n");
        sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
        sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
        sb.append("    contractNum: ").append(toIndentedString(contractNum)).append("\n");
        sb.append("    enterDate: ").append(toIndentedString(enterDate)).append("\n");
        sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    organRequire: ").append(toIndentedString(organRequire)).append("\n");
        sb.append("    checkReportNum: ").append(toIndentedString(checkReportNum)).append("\n");
        sb.append("    credentialNum: ").append(toIndentedString(credentialNum)).append("\n");
        sb.append("    receiptNum: ").append(toIndentedString(receiptNum)).append("\n");
        sb.append("    other: ").append(toIndentedString(other)).append("\n");
        sb.append("    packDemand: ").append(toIndentedString(packDemand)).append("\n");
        sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
        sb.append("    expressCompany: ").append(toIndentedString(expressCompany)).append("\n");
        sb.append("    expressNum: ").append(toIndentedString(expressNum)).append("\n");
        sb.append("    enterStaff: ").append(toIndentedString(enterStaff)).append("\n");
        sb.append("    totalNum: ").append(toIndentedString(totalNum)).append("\n");
        sb.append("    totalProductNum: ").append(toIndentedString(totalProductNum)).append("\n");
        sb.append("    totalLength: ").append(toIndentedString(totalLength)).append("\n");
        sb.append("    totalArea: ").append(toIndentedString(totalArea)).append("\n");
        sb.append("    totalProductArea: ").append(toIndentedString(totalProductArea)).append("\n");
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

