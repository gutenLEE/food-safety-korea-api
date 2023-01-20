package com.food.foodsafetykoreaapi.domain.api.dto;

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

    public Map<String, String> getParamMap(ParamType paramType){

        Map<String, String> map = new HashMap<String, String>();

        if (paramType==ParamType.COMPANY_NAME)
            map.put("BSSH_NM", companyName);
        else
            map.put("PRDLST_NM", productName);

        return map;
    }
}
