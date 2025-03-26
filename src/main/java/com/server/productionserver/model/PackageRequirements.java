package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * package_requirements
 */
@ApiModel(description = "package_requirements")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//打包要求表
public class PackageRequirements   {

    //客户id
    @NotBlank
    @JsonProperty("id")
    private String id;

    @JsonProperty("demand")
    private String demand;

    @NotBlank
    @JsonProperty("num")
    private String num;

    @Id
    @JsonProperty("PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PK;

    public PackageRequirements demand(String demand) {
        this.demand = demand;
        return this;
    }

    /**
     * Get demand
     * @return demand
     */
    @ApiModelProperty(value = "")

    @Size(max=1000)
    public String getdemand() {
        return demand;
    }

    public void setdemand(String demand) {
        this.demand = demand;
    }

    public PackageRequirements id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @ApiModelProperty(required = true, value = "")
    @NotBlank

    @Size(max=100)
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public PackageRequirements num(String num) {
        this.num = num;
        return this;
    }

    /**
     * Get num
     * @return num
     */
    @ApiModelProperty(value = "")

    @Size(max=1000)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public PackageRequirements PK(Long PK) {
        this.PK = PK;
        return this;
    }

    /**
     * Get PK
     * @return PK
     */
    @ApiModelProperty(required = false, value = "")

    public Long getPK() {
        return PK;
    }

    public void setPK(Long PK) {
        this.PK = PK;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PackageRequirements packageRequirements = (PackageRequirements) o;
        return Objects.equals(this.demand, packageRequirements.demand) &&
                Objects.equals(this.id, packageRequirements.id) &&
                Objects.equals(this.num, packageRequirements.num) &&
                Objects.equals(this.PK, packageRequirements.PK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demand, id, num, PK);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PackageRequirements {\n");

        sb.append("    demand: ").append(toIndentedString(demand)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    num: ").append(toIndentedString(num)).append("\n");
        sb.append("    PK: ").append(toIndentedString(PK)).append("\n");
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

