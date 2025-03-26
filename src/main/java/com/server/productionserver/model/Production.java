package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * production
 */
@ApiModel(description = "production")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//产品表
public class Production  {

    @Id
    @NotEmpty
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("size")
    private String size;

    @JsonProperty("cost")
    private String cost;

    @JsonProperty("class")
    private String proClass;

    public Production id(String id) {
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

    public Production name(String name) {
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

    public Production size(String size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     * @return size
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getsize() {
        return size;
    }

    public void setsize(String size) {
        this.size = size;
    }

    public Production cost(String cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Get cost
     * @return cost
     */
    @ApiModelProperty(required = true, value = "")


    public String getcost() {
        return cost;
    }

    public void setcost(String cost) {
        this.cost = cost;
    }

    public Production proClass(String proClass) {
        this.proClass = proClass;
        return this;
    }

    /**
     * Get proClass
     * @return proClass
     */
    @ApiModelProperty(value = "")


    public String getproClass() {
        return proClass;
    }

    public void setproClass(String proClass) {
        this.proClass = proClass;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Production production = (Production) o;
        return Objects.equals(this.id, production.id) &&
                Objects.equals(this.name, production.name) &&
                Objects.equals(this.size, production.size) &&
                Objects.equals(this.cost, production.cost) &&
                Objects.equals(this.proClass, production.proClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, size, cost, proClass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Production {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
        sb.append("    proClass: ").append(toIndentedString(proClass)).append("\n");
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

