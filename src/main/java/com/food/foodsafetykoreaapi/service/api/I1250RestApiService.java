package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import com.food.foodsafetykoreaapi.exceptions.ExceedPageException;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
public class I1250RestApiService implements RestApiService {

    private static final FoodSafetyApiType apiType = FoodSafetyApiType.I1250;

    @Override
    public void request(RequestParamDto requestParamDto) {
        ApiPagination pagination = ApiPagination.builder().page(1).build();
        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(pagination)
                .paramMap(requestParamDto.getParamMap())
                .build();

        try {
            while(true) {
                RestTemplate restTemplate = new RestTemplate();
                ResponseWrapper<I0020ResponseData> responseWrapper = restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
                assert responseWrapper != null;
                ApiResponseDto<I0020ResponseData> apiResponseDto = responseWrapper.getMap().get(apiType.getApiCode());
                System.out.println("apiResponseDto = " + apiResponseDto);
                pagination.paging(apiResponseDto.getTotal_count());
            }
        } catch (ExceedPageException e){
            System.out.println("종료");
        }

    }

}
