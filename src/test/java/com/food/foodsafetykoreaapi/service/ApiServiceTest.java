package com.food.foodsafetykoreaapi.service;

import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.service.api.ApiService;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@WebServiceClientTest
class ApiServiceTest {

    private ApiService apiService;

    @Test
    void urlTest() throws Exception {
        // http://openapi.foodsafetykorea.go.kr/api/
        // 09f855f93fb8481da7b5/
        // C003/json/1/1000/
        // BSSH_NM=노바렉스&PRMS_DT=20210101
        Map<String, String> map = new LinkedHashMap<>();
        map.put("BSSH_NM", "노바렉스");
        map.put("PRMS_DT", "20210101");

        ApiURL apiURL = ApiURL.builder()
                .apiType(FoodSafetyApiType.C003)
                .apiPagination(ApiPagination.builder().page(1).count(2).build())
                .paramMap(map)
                .build();

        assertThat(apiURL.getRequestURL()).isEqualTo("http://openapi.foodsafetykorea.go.kr/api/09f855f93fb8481da7b5/C003/json/1/2/BSSH_NM=노바렉스&PRMS_DT=20210101");

        apiURL = ApiURL.builder()
                .apiType(FoodSafetyApiType.C002)
                .apiPagination(ApiPagination.builder().page(1).count(2).build())
                .paramMap(map)
                .build();
        assertThat(apiURL.getRequestURL()).isEqualTo("http://openapi.foodsafetykorea.go.kr/api/09f855f93fb8481da7b5/C002/json/1/2/BSSH_NM=노바렉스&PRMS_DT=20210101");


    }



}