package com.food.foodsafetykoreaapi.service;

import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.service.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;

@WebServiceClientTest
class RestApiServiceTest {

    @Test
    void test() throws Exception {

        C002RestApiService c002ApiService = new C002RestApiService();
        C003RestApiService c003ApiService = new C003RestApiService();
        I0020RestApiService i0020ApiService = new I0020RestApiService();
        I1250RestApiService i1250ApiService = new I1250RestApiService();

        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "C002";
        c002ApiService.request(requestParamDto);

        requestParamDto.apiType = "C003";
        c003ApiService.request(requestParamDto);

        requestParamDto.apiType = "I-0020";
        i0020ApiService.request(requestParamDto);

        requestParamDto.apiType = "I1250";
        i1250ApiService.request(requestParamDto);

    }



}