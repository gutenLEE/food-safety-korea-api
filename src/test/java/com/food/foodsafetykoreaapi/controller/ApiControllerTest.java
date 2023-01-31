package com.food.foodsafetykoreaapi.controller;

import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.service.api.RestApiService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;

@WebServiceClientTest
class ApiControllerTest {



    @Test
    void requestApiTest() throws Exception {

        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "C003";



    }

    @Test
    void c002ApiServiceTest() throws Exception {
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "C002";

    }

    @Test
    void I1250ServiceTest() throws Exception {
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "I1250";

    }

    @Test
    void I0020ServiceTest() throws Exception {
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName = "노바렉스";
        requestParamDto.apiType = "I-0020";
    }







}