package com.server.productionserver.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String workNum;
    private String comOrder;

    @Min(-1)
    private Integer complete;

    @Max(4)
    @Min(1)
    private Integer formType;
    private String cmd;

}
