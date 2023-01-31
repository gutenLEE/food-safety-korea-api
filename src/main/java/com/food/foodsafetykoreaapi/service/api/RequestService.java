package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;

public interface RequestService<T> {
    ApiResponseDto<T> getResponse(ApiURL apiURL, FoodSafetyApiType apiType);
}
