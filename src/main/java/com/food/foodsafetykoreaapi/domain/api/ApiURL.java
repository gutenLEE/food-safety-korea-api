package com.food.foodsafetykoreaapi.domain.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import lombok.Builder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
public class ApiURL {

    private static String URL = "http://openapi.foodsafetykorea.go.kr/api";
    private static String JSON = "json";
    private final String apiKey;
    private final FoodSafetyApiType apiType;
    private final ApiPagination apiPagination;
    private final Map<String, String> paramMap;

    @Builder
    public ApiURL(
            String apiKey,
            FoodSafetyApiType apiType,
            ApiPagination apiPagination,
            Map<String, String> paramMap
    ) {
        this.apiKey = apiKey;
        this.apiType = apiType;
        this.apiPagination = apiPagination;
        this.paramMap = paramMap;
    }

    public String getRequestURL(){
        String params = toQueryString();

        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(URL)
                .pathSegment(
                        apiKey,
                        apiType.name(),
                        JSON,
                        apiPagination.getPage(),
                        apiPagination.getCount(),
                        params
                )
                .build();

        return uriComponents.toUriString();
    }

    private String toQueryString() {
        return paramMap.entrySet().stream()
                .map(entry -> {
                    return entry.getKey() + "=" + entry.getValue();
                })
                .collect(Collectors.joining("&"));
    }
}
