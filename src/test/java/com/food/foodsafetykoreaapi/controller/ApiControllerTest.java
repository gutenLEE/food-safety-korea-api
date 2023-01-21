package com.food.foodsafetykoreaapi.controller;

import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.service.api.ApiFactory;
import com.food.foodsafetykoreaapi.service.api.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;

@WebServiceClientTest
class ApiControllerTest {

    private ApiFactory apiFactory = new ApiFactory();

    @Test
    void requestApiTest() throws Exception {

        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "C003";

        ApiService apiService = apiFactory.createApiService(requestParamDto.getApiType());
        apiService.request(requestParamDto);


    }



}