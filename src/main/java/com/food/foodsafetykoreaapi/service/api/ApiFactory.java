package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.stereotype.Service;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
@Service
public class ApiFactory {

    public RestApiService createApiService(FoodSafetyApiType apiType){

        if (apiType == FoodSafetyApiType.C003)
            return new C003RestApiService();
        else if (apiType == FoodSafetyApiType.C002)
            return new C002RestApiService();
        else if (apiType == FoodSafetyApiType.I1250)
            return new I1250RestApiService();
        else if(apiType == FoodSafetyApiType.I0020)
            return new I0020RestApiService();

        throw new RuntimeException("not found service");
    }
}
