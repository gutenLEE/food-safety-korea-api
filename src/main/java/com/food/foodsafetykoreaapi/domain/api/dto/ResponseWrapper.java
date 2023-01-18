package com.food.foodsafetykoreaapi.domain.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author gutenlee
 * @since 2023/01/18
 */
public class ResponseWrapper<T> {

    @JsonProperty("C003")
    private ApiResponseDto<T> apiResponseDto;
}
