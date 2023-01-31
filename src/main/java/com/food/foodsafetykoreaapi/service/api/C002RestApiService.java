package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;

/**
 * @author gutenlee
 * @since 2023/01/21
 */
public class C002RestApiService implements RestApiService<C002ResponseData> {

    private final RestTemplateRequestService<C002ResponseData> RestTemplateRequestService;

    public C002RestApiService(RestTemplateRequestService<C002ResponseData> RestTemplateRequestService) {
        this.RestTemplateRequestService = RestTemplateRequestService;
    }


    public ApiResponseDto<C002ResponseData> request(RequestParamDto requestParamDto) {

        FoodSafetyApiType apiType = requestParamDto.getApiType();
        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(ApiPagination.builder().page(1).build())
                .paramMap(requestParamDto.getParamMap())
                .build();

        return RestTemplateRequestService.getResponse(apiURL, apiType);
    }
}
