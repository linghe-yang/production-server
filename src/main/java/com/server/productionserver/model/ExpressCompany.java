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
 * express_company
 */
@ApiModel(description = "express_company")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
public class ExpressCompany   {
    @JsonProperty("express_name")
    private String expressName;

    @JsonProperty("work_id")
    @NotEmpty
    @Id
    private String workId;

    public ExpressCompany expressName(String expressName) {
        this.expressName = expressName;
        return this;
    }

    /**
     * Get expressName
     * @return expressName
     */
    @ApiModelProperty(required = true, value = "")
    @NotEmpty

    @Size(max=100)
    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public ExpressCompany workId(String workId) {
        this.workId = workId;
        return this;
    }

    /**
     * Get workId
     * @return workId
     */
    @ApiModelProperty(required = true, value = "")
    @NotEmpty


    public String getworkId() {
        return workId;
    }

    public void setworkId(String workId) {
        this.workId = workId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpressCompany expressCompany = (ExpressCompany) o;
        return Objects.equals(this.expressName, expressCompany.expressName) &&
                Objects.equals(this.workId, expressCompany.workId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressName, workId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExpressCompany {\n");

        sb.append("    expressName: ").append(toIndentedString(expressName)).append("\n");
        sb.append("    workId: ").append(toIndentedString(workId)).append("\n");
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

