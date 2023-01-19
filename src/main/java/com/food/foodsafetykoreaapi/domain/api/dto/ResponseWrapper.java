package com.food.foodsafetykoreaapi.domain.api.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gutenlee
 * @since 2023/01/18
 */
@Data
public class ResponseWrapper<T> {

    Map<String, ApiResponseDto<T>> map = new LinkedHashMap<>();

    @JsonAnySetter
    void setMap(String key, ApiResponseDto<T> responseDto) {
        map.put(key, responseDto);
    }

}
