package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * motherBill
 */
@ApiModel(description = "motherBill")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
public class MotherBill {
    @Id
    @NotEmpty
    @JsonProperty("mb_num")
    private String mbNum;

    @JsonProperty("enter_date")
    private String enterDate;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("house_type")
    private String houseType;

    @JsonProperty("notice_num")
    private String noticeNum;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("set_num")
    private String setNum;

    @JsonProperty("full_length")
    private String fullLength;

    @JsonProperty("piece_num")
    private String pieceNum;

    @JsonProperty("organ_require")
    private String organRequire;

    @JsonProperty("full_area")
    private String fullArea;

    @JsonProperty("product_area")
    private String productArea;

    @JsonProperty("pack_demand")
    private String packDemand;

    @JsonProperty("orientation")
    private String orientation;

    @JsonProperty("full_piece_num")
    private String fullPieceNum;

    public MotherBill mbNum(String mbNum) {
        this.mbNum = mbNum;
        return this;
    }

    /**
     * Get mbNum
     * @return mbNum
     */
    @ApiModelProperty(required = true, value = "")
    @NotEmpty
    @Size(max=100)
    public String getMbNum() {
        return mbNum;
    }

    public void setMbNum(String mbNum) {
        this.mbNum = mbNum;
    }

    public MotherBill enterDate(String enterDate) {
        this.enterDate = enterDate;
        return this;
    }

    /**
     * Get enterDate
     * @return enterDate
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public MotherBill customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * Get customerName
     * @return customerName
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public MotherBill houseType(String houseType) {
        this.houseType = houseType;
        return this;
    }

    /**
     * Get houseType
     * @return houseType
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public MotherBill noticeNum(String noticeNum) {
        this.noticeNum = noticeNum;
        return this;
    }

    /**
     * Get noticeNum
     * @return noticeNum
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(String noticeNum) {
        this.noticeNum = noticeNum;
    }

    public MotherBill projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    /**
     * Get projectName
     * @return projectName
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public MotherBill setNum(String setNum) {
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

    public MotherBill fullLength(String fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    /**
     * Get fullLength
     * @return fullLength
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getFullLength() {
        return fullLength;
    }

    public void setFullLength(String fullLength) {
        this.fullLength = fullLength;
    }

    public MotherBill pieceNum(String pieceNum) {
        this.pieceNum = pieceNum;
        return this;
    }

    /**
     * Get pieceNum
     * @return pieceNum
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getPieceNum() {
        return pieceNum;
    }

    public void setPieceNum(String pieceNum) {
        this.pieceNum = pieceNum;
    }

    public MotherBill organRequire(String organRequire) {
        this.organRequire = organRequire;
        return this;
    }

    /**
     * Get organRequire
     * @return organRequire
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getOrganRequire() {
        return organRequire;
    }

    public void setOrganRequire(String organRequire) {
        this.organRequire = organRequire;
    }

    public MotherBill fullArea(String fullArea) {
        this.fullArea = fullArea;
        return this;
    }

    /**
     * Get fullArea
     * @return fullArea
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getFullArea() {
        return fullArea;
    }

    public void setFullArea(String fullArea) {
        this.fullArea = fullArea;
    }

    public MotherBill productArea(String productArea) {
        this.productArea = productArea;
        return this;
    }

    /**
     * Get productArea
     * @return productArea
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public MotherBill packDemand(String packDemand) {
        this.packDemand = packDemand;
        return this;
    }

    /**
     * Get packDemand
     * @return packDemand
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getPackDemand() {
        return packDemand;
    }

    public void setPackDemand(String packDemand) {
        this.packDemand = packDemand;
    }

    public MotherBill orientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    /**
     * Get orientation
     * @return orientation
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public MotherBill fullPieceNum(String fullPieceNum) {
        this.fullPieceNum = fullPieceNum;
        return this;
    }

    /**
     * Get fullPieceNum
     * @return fullPieceNum
     */
    @ApiModelProperty(value = "")
    @Size(max=100)
    public String getFullPieceNum() {
        return fullPieceNum;
    }

    public void setFullPieceNum(String fullPieceNum) {
        this.fullPieceNum = fullPieceNum;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MotherBill motherBill = (MotherBill) o;
        return Objects.equals(this.mbNum, motherBill.mbNum) &&
                Objects.equals(this.enterDate, motherBill.enterDate) &&
                Objects.equals(this.customerName, motherBill.customerName) &&
                Objects.equals(this.houseType, motherBill.houseType) &&
                Objects.equals(this.noticeNum, motherBill.noticeNum) &&
                Objects.equals(this.projectName, motherBill.projectName) &&
                Objects.equals(this.setNum, motherBill.setNum) &&
                Objects.equals(this.fullLength, motherBill.fullLength) &&
                Objects.equals(this.pieceNum, motherBill.pieceNum) &&
                Objects.equals(this.organRequire, motherBill.organRequire) &&
                Objects.equals(this.fullArea, motherBill.fullArea) &&
                Objects.equals(this.productArea, motherBill.productArea) &&
                Objects.equals(this.packDemand, motherBill.packDemand) &&
                Objects.equals(this.orientation, motherBill.orientation) &&
                Objects.equals(this.fullPieceNum, motherBill.fullPieceNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mbNum, enterDate, customerName, houseType, noticeNum, projectName, setNum, fullLength, pieceNum, organRequire, fullArea, productArea, packDemand, orientation, fullPieceNum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MotherBill {\n");

        sb.append("    mbNum: ").append(toIndentedString(mbNum)).append("\n");
        sb.append("    enterDate: ").append(toIndentedString(enterDate)).append("\n");
        sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
        sb.append("    houseType: ").append(toIndentedString(houseType)).append("\n");
        sb.append("    noticeNum: ").append(toIndentedString(noticeNum)).append("\n");
        sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
        sb.append("    setNum: ").append(toIndentedString(setNum)).append("\n");
        sb.append("    fullLength: ").append(toIndentedString(fullLength)).append("\n");
        sb.append("    pieceNum: ").append(toIndentedString(pieceNum)).append("\n");
        sb.append("    organRequire: ").append(toIndentedString(organRequire)).append("\n");
        sb.append("    fullArea: ").append(toIndentedString(fullArea)).append("\n");
        sb.append("    productArea: ").append(toIndentedString(productArea)).append("\n");
        sb.append("    packDemand: ").append(toIndentedString(packDemand)).append("\n");
        sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
        sb.append("    fullPieceNum: ").append(toIndentedString(fullPieceNum)).append("\n");
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
