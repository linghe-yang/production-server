package com.server.productionserver.model;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * component
 */
@ApiModel(description = "backupcom")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//备品规格表
public class BackUpCom {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("length")
    private String length;

    @JsonProperty("width")
    private String width;


    public BackUpCom id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }


    public BackUpCom length(String length) {
        this.length = length;
        return this;
    }

    /**
     * Get length
     * @return length
     */
    @ApiModelProperty(value = "")

    public String getlength() {
        return length;
    }

    public void setlength(String length) {
        this.length = length;
    }

    public BackUpCom width(String width) {
        this.width = width;
        return this;
    }

    /**
     * Get width
     * @return width
     */
    @ApiModelProperty(value = "")

    public String getwidth() {
        return width;
    }

    public void setwidth(String width) {
        this.width = width;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackUpCom backUpCom = (BackUpCom) o;
        return Objects.equals(this.id, backUpCom.id) &&
                Objects.equals(this.length, backUpCom.length) &&
                Objects.equals(this.width, backUpCom.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, length, width);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BackUpCom {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    length: ").append(toIndentedString(length)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
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

