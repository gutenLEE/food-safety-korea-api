package com.food.foodsafetykoreaapi.domain.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
@Slf4j
public class ApiURL {

    private static final String URL = "http://openapi.foodsafetykorea.go.kr/api";
    private static final String JSON = "json";
    private static final String apiKey = "09f855f93fb8481da7b5";
    private final FoodSafetyApiType apiType;
    private final ApiPagination apiPagination;
    private final Map<String, String> paramMap;

    @Builder
    public ApiURL(
            FoodSafetyApiType apiType,
            ApiPagination apiPagination,
            Map<String, String> paramMap
    ) {
        this.apiType = apiType;
        this.apiPagination = apiPagination;
        this.paramMap = paramMap;
    }

    public String getRequestURL(){
        String params = toQueryString();

        log.info("request page " + apiPagination.toString());
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(URL)
                .pathSegment(
                        apiKey,
                        apiType.getApiCode(),
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

    public ApiPagination getInitPagination() {
        return apiPagination;
    }
}
