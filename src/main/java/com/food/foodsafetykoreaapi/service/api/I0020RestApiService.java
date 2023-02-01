package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.stereotype.Service;

import static com.food.foodsafetykoreaapi.domain.api.ApiPagination.initPage;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
@Service
public class I0020RestApiService implements RestApiService<I0020ResponseData>, ApiPageable{

    private final RestTemplateRequestService<I0020ResponseData> RestTemplateRequestService;

    public I0020RestApiService(RestTemplateRequestService<I0020ResponseData> RestTemplateRequestService) {
        this.RestTemplateRequestService = RestTemplateRequestService;
    }

    @Override
    public ApiResponseDto<I0020ResponseData> request(
            RequestParamDto requestParamDto,
            ApiPagination apiPagination) {

        ApiPagination pagination = ApiPagination.builder().page(1).build();
        FoodSafetyApiType apiType = requestParamDto.getApiType();

        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(pagination)
                .paramMap(requestParamDto.getParamMap())
                .build();

        return RestTemplateRequestService.getResponse(apiURL, apiType);
    }

    @Override
    public ApiPagination createPagination(int countPerPage) {
        return initPage(countPerPage);
    }
}
