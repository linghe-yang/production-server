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
 * box
 */
@ApiModel(description = "box")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//箱表
public class Box   {

    @Id
    @NotEmpty
    @JsonProperty("id")
    private String id;

    @JsonProperty("box_name")
    private String boxName;

    @JsonProperty("color")
    private String color;

    @JsonProperty("work_id")
    private String workId;

    public Box id(String id) {
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

    public Box boxName(String boxName) {
        this.boxName = boxName;
        return this;
    }

    /**
     * Get boxName
     * @return boxName
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public Box color(String color) {
        this.color = color;
        return this;
    }

    /**
     * Get color
     * @return color
     */
    @ApiModelProperty(value = "")

    @Size(max=100)
    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public Box workId(String workId) {
        this.workId = workId;
        return this;
    }

    /**
     * Get workId
     * @return workId
     */
    @ApiModelProperty(required = true, value = "")


    public String getworkId() {
        return workId;
    }

    public void setWorkId(String workId) {
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
        Box box = (Box) o;
        return Objects.equals(this.id, box.id) &&
                Objects.equals(this.boxName, box.boxName) &&
                Objects.equals(this.color, box.color) &&
                Objects.equals(this.workId, box.workId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boxName, color, workId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Box {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    boxName: ").append(toIndentedString(boxName)).append("\n");
        sb.append("    color: ").append(toIndentedString(color)).append("\n");
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

