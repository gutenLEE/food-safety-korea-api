package com.food.foodsafetykoreaapi.domain.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gutenlee
 * @since 2023/01/18
 */
@Data
public class ApiResponseDto<T> {

    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("RESULT")
    private ResultStatusDto resultStatusDto;
    @JsonProperty("row")
    private List<T> row;

    public boolean isOk(){
        return this.resultStatusDto.getCODE().equals("INFO-000");
    }
}
