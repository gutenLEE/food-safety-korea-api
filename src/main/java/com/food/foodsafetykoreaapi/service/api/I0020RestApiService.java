package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
public class I0020RestApiService implements RestApiService {
    private static final FoodSafetyApiType apiType = FoodSafetyApiType.I0020;

    @Override
    public void request(RequestParamDto requestParamDto) {
        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(ApiPagination.builder().page(1).build())
                .paramMap(requestParamDto.getParamMap())
                .build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapper<I0020ResponseData> responseWrapper = restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
        assert responseWrapper != null;
        ApiResponseDto<I0020ResponseData> apiResponseDto = responseWrapper.getMap().get(apiType.getApiCode());
        System.out.println("apiResponseDto = " + apiResponseDto);
    }
}
