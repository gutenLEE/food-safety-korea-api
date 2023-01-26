package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.C003ResponseData;
import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.domain.api.dto.ResponseWrapper;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/21
 */
public class C003RestApiService implements RestApiService {

    private static final FoodSafetyApiType apiType = FoodSafetyApiType.C003;

    @Override
    public void request(RequestParamDto requestParamDto) {

        ApiURL apiURL = ApiURL.builder()
                .apiType(FoodSafetyApiType.C003)
                .apiPagination(ApiPagination.builder().page(1).build())
                .paramMap(requestParamDto.getParamMap())
                .build();

        FoodSafetyApiType apiType = requestParamDto.getApiType();
        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapper<C003ResponseData> responseWrapper = restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
        assert responseWrapper != null;
        ApiResponseDto<C003ResponseData> apiResponseDto = responseWrapper.getMap().get("C003");
        System.out.println("apiResponseDto = " + apiResponseDto);
    }
}
