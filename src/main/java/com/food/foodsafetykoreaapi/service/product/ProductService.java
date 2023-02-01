package com.food.foodsafetykoreaapi.service.product;

import com.food.foodsafetykoreaapi.domain.api.dto.I1250ResponseData;
import com.food.foodsafetykoreaapi.service.api.I1250RestApiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gutenlee
 * @since 2023/02/01
 */
@Service
public class ProductService {

    private final I1250RestApiService i1250RestApiService;

    public ProductService(I1250RestApiService i1250RestApiService) {
        this.i1250RestApiService = i1250RestApiService;
    }



}
