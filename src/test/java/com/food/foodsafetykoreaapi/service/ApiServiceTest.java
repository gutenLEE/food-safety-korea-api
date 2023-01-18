package com.food.foodsafetykoreaapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;

@WebServiceClientTest
class ApiServiceTest {

    private ApiService apiService = new TestApiServiceImpl();

    @Test
    void requestTest() throws Exception {

        apiService.request();
    }


}