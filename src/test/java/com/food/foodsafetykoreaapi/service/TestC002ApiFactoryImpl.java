package com.food.foodsafetykoreaapi.service;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import com.food.foodsafetykoreaapi.service.api.ApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.food.foodsafetykoreaapi.domain.api.ApiPagination.initialPaging;

/**
 * @author gutenlee
 * @since 2023/01/20
 */
public class TestC002ApiFactoryImpl implements ApiFactory {


    @Override
    public void request(ApiURL apiURL) {

    }

    @Test
    void request() throws Exception {
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        Map<String, String> paramMap = requestParamDto.getParamMap(ParamType.COMPANY_NAME);

        ApiPagination initialPaging = initialPaging();

        ApiURL apiURL = new ApiURL(
                FoodSafetyApiType.C002,
                initialPaging,
                paramMap
        );

        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapper<C003ResponseData> responseWrapper = restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
        assert responseWrapper != null;
        ApiResponseDto<C003ResponseData> apiResponseDto = responseWrapper.getMap().get(FoodSafetyApiType.C002.getApiCode());
        System.out.println("apiResponseDto = " + apiResponseDto);
    }


}
