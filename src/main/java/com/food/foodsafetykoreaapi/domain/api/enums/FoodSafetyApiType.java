package com.food.foodsafetykoreaapi.domain.api.enums;


public enum FoodSafetyApiType {

    C003("C003","건강기능식품 품목제조신고(원재료)"),
    I1250("I-1250","식품(첨가물)품목제조보고"),
    C002("C002","식품(첨가물)품목제조보고(원재료)"),
    I0020("I-0020","건강기능식품 전문.벤처제조업인허가 현황")
    ;

    private final String apiCode;
    private final String apiName;

    FoodSafetyApiType(
            String apiCode,
            String apiName
    ) {
        this.apiCode = apiCode;
        this.apiName = apiName;
    }

    public String getApiCode() {
        return apiCode;
    }

    public String getApiName() {
        return apiName;
    }
}
