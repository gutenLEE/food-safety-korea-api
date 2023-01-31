package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import com.food.foodsafetykoreaapi.exceptions.ExceedPageException;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
public class I1250RestApiService implements RestApiService<I1250ResponseData>, ApiPageable {

    private final RestTemplateRequestService<I1250ResponseData> RestTemplateRequestService;

    public I1250RestApiService(RestTemplateRequestService<I1250ResponseData> RestTemplateRequestService) {
        this.RestTemplateRequestService = RestTemplateRequestService;
    }

    @Override
    public ApiResponseDto<I1250ResponseData> request(RequestParamDto requestParamDto) {

        ApiPagination pagination = ApiPagination.builder().page(1).build();
        FoodSafetyApiType apiType = requestParamDto.getApiType();

        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(pagination)
                .paramMap(requestParamDto.getParamMap())
                .build();

       RestTemplateRequestService.getResponse(apiURL, apiType);

       while (true) {

       }
    }

    @Override
    public ApiPagination getNextPage(int responseDataCount) {
        return null;
    }
}
