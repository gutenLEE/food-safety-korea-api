package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;

public interface RestApiService<T> {
    ApiResponseDto<T> request(RequestParamDto requestParamDto);
}
