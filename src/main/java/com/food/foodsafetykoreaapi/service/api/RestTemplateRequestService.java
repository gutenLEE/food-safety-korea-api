package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.ResponseWrapper;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/31
 */
@Service
public class RestTemplateRequestService<T> implements RequestService<T> {

    private final RestTemplate foodApiRestTemplate;


    public RestTemplateRequestService(RestTemplate foodApiRestTemplate) {
        this.foodApiRestTemplate = foodApiRestTemplate;
    }


    @Override
    public ApiResponseDto<T> getResponse(ApiURL apiURL, FoodSafetyApiType apiType) {

        ResponseWrapper<T> responseWrapper =
                foodApiRestTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
        assert responseWrapper != null;
        return responseWrapper.getMap().get(apiType.getApiCode());
    }

}
