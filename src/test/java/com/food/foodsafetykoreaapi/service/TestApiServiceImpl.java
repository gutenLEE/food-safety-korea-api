package com.food.foodsafetykoreaapi.service;

import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.C003ResponseData;
import com.food.foodsafetykoreaapi.domain.api.dto.ResponseWrapper;
import com.food.foodsafetykoreaapi.service.api.ApiService;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/14
 */
public class TestApiServiceImpl  {

    public void request() {

        // http://openapi.foodsafetykorea.go.kr/api/
        // 09f855f93fb8481da7b5/
        // C003/json/1/1000/
        // BSSH_NM=노바렉스&PRMS_DT=20210101
        String url = "http://openapi.foodsafetykorea.go.kr/api/09f855f93fb8481da7b5/C003/json/1/1/BSSH_NM=노바렉스&PRMS_DT=20210101";

        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapper<C003ResponseData> responseWrapper = restTemplate.getForObject(url, ResponseWrapper.class);
        assert responseWrapper != null;
        ApiResponseDto<C003ResponseData> apiResponseDto = responseWrapper.getMap().get("C003");
        System.out.println("apiResponseDto = " + apiResponseDto);

    }
}
