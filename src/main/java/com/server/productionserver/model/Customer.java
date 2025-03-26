package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * customer
 */
@ApiModel(description = "customer")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//客户表
public class Customer   {

    @Id
    @NotEmpty
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("order_time")
    private String orderTime;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("pro_id")
    private String proId;

    public Customer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @ApiModelProperty(required = true, value = "")
    @NotEmpty

    @Size(max=100)
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Customer orderTime(String orderTime) {
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

    public Customer address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     * @return address
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public Customer phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     * @return phone
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public Customer logo(String logo) {
        this.logo = logo;
        return this;
    }

    /**
     * Get logo
     * @return logo
     */
    @ApiModelProperty(value = "")


    public String getlogo() {
        return logo;
    }

    public void setlogo(String logo) {
        this.logo = logo;
    }

    public Customer proId(String proId) {
        this.proId = proId;
        return this;
    }

    /**
     * Get proId
     * @return proId
     */
    @ApiModelProperty(value = "")


    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) &&
                Objects.equals(this.name, customer.name) &&
                Objects.equals(this.orderTime, customer.orderTime) &&
                Objects.equals(this.address, customer.address) &&
                Objects.equals(this.phone, customer.phone) &&
                Objects.equals(this.logo, customer.logo) &&
                Objects.equals(this.proId, customer.proId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orderTime, address, phone, logo, proId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    orderTime: ").append(toIndentedString(orderTime)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
        sb.append("    proId: ").append(toIndentedString(proId)).append("\n");
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

