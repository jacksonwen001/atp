package com.chancetop.atp.vo;

import com.chancetop.atp.entites.ApiTestEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDetails {
    @JsonProperty("api")
    private ApiTestEntity apiTestEntity;
    
}
