package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.common.RestTemplateComponent;
import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.I1250ResponseData;
import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.context.annotation.Import;

@WebServiceClientTest()
@Import(RestTemplateComponent.class)
class I1250RestApiServiceTest {

    @Autowired
    RestTemplateComponent restTemplateComponent;
    private I1250RestApiService i1250RestApiService = new I1250RestApiService(
            new RestTemplateRequestService<>(RestTemplateComponent.foodApiRestTemplate())
    );

    @Test
    void requestTest() throws Exception {

        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName="노바렉스";
        requestParamDto.apiType = "I1250";

        ApiPagination pagination = i1250RestApiService.createPagination(20);

        while (true) {
            ApiResponseDto<I1250ResponseData> responseDto =
                    i1250RestApiService.request(requestParamDto, pagination);
            System.out.println("responseDto = " + responseDto);

            pagination = pagination.getNextPage(responseDto.getTotalCount());
        }

    }


}