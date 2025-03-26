package com.server.productionserver.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @version 1.0
 * @auther Ethan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")
@Entity
//备品规格表
public class LargeProject {
    @Id
    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("receiver")
    private String receiver;

    @JsonProperty("receive_obj")
    private String receiveObj;

    @JsonProperty("address")
    private String address;

}
