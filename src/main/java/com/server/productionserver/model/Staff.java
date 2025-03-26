package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * staff
 */
@ApiModel(description = "staff")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//职工表
public class Staff {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("duty")
    private String duty;

    public Staff id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * maximum: 2147483647
     * @return id
     */
    @ApiModelProperty(value = "")
    @Min(-100) @Max(2147483647)
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public Staff name(String name) {
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

    public Staff password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     * @return password
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public Staff phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     * @return phone
     */
    @ApiModelProperty(value = "")
    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public Staff duty(String duty) {
        this.duty = duty;
        return this;
    }

    /**
     * Get duty
     * @return duty
     */
    @ApiModelProperty(value = "")
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Staff staff = (Staff) o;
        return Objects.equals(this.id, staff.id) &&
                Objects.equals(this.name, staff.name) &&
                Objects.equals(this.password, staff.password) &&
                Objects.equals(this.phone, staff.phone) &&
                Objects.equals(this.duty, staff.duty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, phone, duty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Staff {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    duty: ").append(toIndentedString(duty)).append("\n");
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

