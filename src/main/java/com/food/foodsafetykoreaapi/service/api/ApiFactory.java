package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
public interface ApiFactory {
    void request(ApiURL apiURL);
}
