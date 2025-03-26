package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * organization_requirements
 */
@ApiModel(description = "organization_requirements")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//整理要求表
public class OrganizationRequirements {
    @JsonProperty("demand")
    private String demand;

    @NotBlank
    @JsonProperty("id")
    private String id;

    @NotBlank
    @JsonProperty("num")
    private String num;

    @Id
    @JsonProperty("PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PK;

    public OrganizationRequirements demand(String demand) {
        this.demand = demand;
        return this;
    }

    /**
     * Get demand
     * @return demand
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getdemand() {
        return demand;
    }

    public void setdemand(String demand) {
        this.demand = demand;
    }

    public OrganizationRequirements id(String id) {
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

    public OrganizationRequirements num(String num) {
        this.num = num;
        return this;
    }

    /**
     * Get num
     * @return num
     */
    @ApiModelProperty(value = "")
    @Size(max=100)

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public OrganizationRequirements PK(Long PK) {
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
        OrganizationRequirements organizationRequirements = (OrganizationRequirements) o;
        return Objects.equals(this.demand, organizationRequirements.demand) &&
                Objects.equals(this.id, organizationRequirements.id) &&
                Objects.equals(this.num, organizationRequirements.num) &&
                Objects.equals(this.PK, organizationRequirements.PK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demand, id, num, PK);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrganizationRequirement {\n");

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

