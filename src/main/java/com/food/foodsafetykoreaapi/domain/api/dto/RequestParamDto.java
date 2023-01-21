package com.food.foodsafetykoreaapi.domain.api.dto;

import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gutenlee
 * @since 2023/01/14
 */
public class RequestParamDto {
    public String companyName;
    public String productName;
    public String apiType;
    public ParamType paramType;

    public Map<String, String> getParamMap(){

        Map<String, String> map = new HashMap<String, String>();

        if (companyName!=null){
            this.paramType = ParamType.COMPANY_NAME;
            map.put("BSSH_NM", companyName);
        }
        else {
            this.paramType = ParamType.PRODUCT_NAME;
            map.put("PRDLST_NM", productName);
        }
        return map;
    }

    public FoodSafetyApiType getApiType(){
        return FoodSafetyApiType.getApiType(apiType);
    }
}
