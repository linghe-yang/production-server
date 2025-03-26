package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FanHuiXiangYing
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

public class FanHuiXiangYing   {
    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Object data;

    public FanHuiXiangYing code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     * @return code
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public FanHuiXiangYing message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FanHuiXiangYing data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     * @return data
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FanHuiXiangYing fanHuiXiangYing = (FanHuiXiangYing) o;
        return Objects.equals(this.code, fanHuiXiangYing.code) &&
                Objects.equals(this.message, fanHuiXiangYing.message) &&
                Objects.equals(this.data, fanHuiXiangYing.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FanHuiXiangYing {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

