package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;

public interface ApiPageable {
    ApiPagination getNextPage(int responseDataCount);
}
