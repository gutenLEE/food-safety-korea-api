package com.food.foodsafetykoreaapi.controller;

import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.service.api.ApiFactory;
import com.food.foodsafetykoreaapi.service.api.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gutenlee
 * @since 2023/01/21
 */

@Controller
@RequestMapping("api")
public class ApiController {

    private final ApiFactory apiFactory;

    public ApiController(
            ApiFactory apiFactory
    ) {
        this.apiFactory = apiFactory;
    }

    @PostMapping("request")
    public void requestApi(@RequestBody RequestParamDto requestParamDto){
        ApiService apiService = apiFactory.createApiService(requestParamDto.getApiType());
        apiService.request(requestParamDto);
    }
}
