package com.server.productionserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.Entity;
/**
 * project
 */
@ApiModel(description = "project")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Entity
//项目表
public class Project   {
    @Id
    @NotBlank
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("finish")
    @Min(0)@Max(1)
    private Integer finish;

    public Project id(String id) {
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

    public Project name(String name) {
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

    public Project finish(Integer finish) {
        this.finish = finish;
        return this;
    }

    /**
     * Get finish
     * @return finish
     */
    @ApiModelProperty(value = "")
    @Min(0)@Max(1)
    public Integer getfinish() {
        return finish;
    }

    public void setfinish(Integer finish) {
        this.finish = finish;
    }



    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(this.id, project.id) &&
                Objects.equals(this.name, project.name) &&
                Objects.equals(this.finish, project.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, finish);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Project {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    finish: ").append(toIndentedString(finish)).append("\n");
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

