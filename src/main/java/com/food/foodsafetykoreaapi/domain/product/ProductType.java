package com.food.foodsafetykoreaapi.domain.product;

public enum ProductType {

    FOOD("식품"),
    HEALTH_SUPPLEMENT("건강기능식품")
    ;

    private final String productTypeName;


    ProductType(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
