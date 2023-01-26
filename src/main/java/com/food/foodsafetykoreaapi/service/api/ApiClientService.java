package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.ResponseWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/26
 */

public class ApiClientService {

    private final RestTemplate restTemplate;

    public ApiClientService( ) {
        this.restTemplate = new RestTemplate();
    }

    public ResponseWrapper getResponse(ApiURL apiURL) {
        return restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
    }


}
