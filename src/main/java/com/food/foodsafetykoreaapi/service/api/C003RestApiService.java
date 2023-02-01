package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.stereotype.Service;

import static com.food.foodsafetykoreaapi.domain.api.ApiPagination.initPage;

/**
 * @author gutenlee
 * @since 2023/01/21
 */
@Service
public class C003RestApiService implements RestApiService<C003ResponseData>, ApiPageable {

    private final RestTemplateRequestService<C003ResponseData> RestTemplateRequestService;


    public C003RestApiService(RestTemplateRequestService<C003ResponseData> RestTemplateRequestService) {
        this.RestTemplateRequestService = RestTemplateRequestService;
    }

    @Override
    public ApiResponseDto<C003ResponseData> request(RequestParamDto requestParamDto, ApiPagination apiPagination) {

        FoodSafetyApiType apiType = requestParamDto.getApiType();
        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(ApiPagination.builder().page(1).build())
                .paramMap(requestParamDto.getParamMap())
                .build();

        return RestTemplateRequestService.getResponse(apiURL, apiType);
    }

    @Override
    public ApiPagination createPagination(int countPerPage) {
        return initPage(countPerPage);
    }
}
