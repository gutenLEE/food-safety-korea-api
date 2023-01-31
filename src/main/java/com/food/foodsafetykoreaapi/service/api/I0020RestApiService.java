package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
public class I0020RestApiService implements RestApiService<I0020ResponseData> {

    private final RestTemplateRequestService<I0020ResponseData> RestTemplateRequestService;

    public I0020RestApiService(RestTemplateRequestService<I0020ResponseData> RestTemplateRequestService) {
        this.RestTemplateRequestService = RestTemplateRequestService;
    }

    @Override
    public ApiResponseDto<I0020ResponseData> request(RequestParamDto requestParamDto) {

        ApiPagination pagination = ApiPagination.builder().page(1).build();
        FoodSafetyApiType apiType = requestParamDto.getApiType();

        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(pagination)
                .paramMap(requestParamDto.getParamMap())
                .build();

        return RestTemplateRequestService.getResponse(apiURL, apiType);
    }
}
