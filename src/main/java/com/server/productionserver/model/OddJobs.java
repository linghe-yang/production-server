package com.server.productionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * 杂活备注表
 */
@ApiModel(description = "OddJobs")
@Entity
public class OddJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置为自增主键
    @JsonProperty("id")
    private Long id;

    @JsonProperty("date")
    private String date;

    @JsonProperty("stuff_name")
    private String stuffName;

    @JsonProperty("other")
    private String other;



    public OddJobs id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @ApiModelProperty(required = false, value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public OddJobs stuffName(String name) {
        this.stuffName = stuffName;
        return this;
    }

    /**
     * Get stuffName
     * @return stuffName
     */
    @ApiModelProperty(value = "")
    @Size(max=255)
    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }



    public OddJobs other(String other) {
        this.other = other;
        return this;
    }

    /**
     * Get other
     * @return other
     */
    @ApiModelProperty(value = "")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }



    public OddJobs date(String date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     * @return date
     */
    @ApiModelProperty(value = "")

    @Size(max=255)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OddJobs oddJobs = (OddJobs) o;
        return Objects.equals(this.id, oddJobs.id) &&
                Objects.equals(this.stuffName, oddJobs.stuffName) &&
                Objects.equals(this.other, oddJobs.other) &&
                Objects.equals(this.date, oddJobs.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuffName, other, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OddJobs {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    stuffName: ").append(toIndentedString(stuffName)).append("\n");
        sb.append("    other: ").append(toIndentedString(other)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
