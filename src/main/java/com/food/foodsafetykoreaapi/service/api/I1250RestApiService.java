package com.food.foodsafetykoreaapi.service.api;

import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.ApiURL;
import com.food.foodsafetykoreaapi.domain.api.dto.*;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/23
 */
public class I1250RestApiService implements RestApiService, RestApiPageable {

    private static final FoodSafetyApiType apiType = FoodSafetyApiType.I1250;
    private static final int COUNT_PER_PAGE = 15;

    @Override
    public void request(RequestParamDto requestParamDto) {
        ApiURL apiURL = ApiURL.builder()
                .apiType(apiType)
                .apiPagination(ApiPagination.initialPage())
                .paramMap(requestParamDto.getParamMap())
                .build();

        ApiPagination paging = paging(apiURL);

    }

    @Override
    public ApiPagination paging(ApiURL apiURL) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapper<I1250ResponseData> responseWrapper = restTemplate.getForObject(apiURL.getRequestURL(), ResponseWrapper.class);
        assert responseWrapper != null;
        ApiResponseDto<I1250ResponseData> apiResponseDto = responseWrapper.getMap().get(apiType.getApiCode());
        System.out.println("apiResponseDto for paging = " + apiResponseDto);

        int totalCount = apiResponseDto.getTotal_count();

        int pages = totalCount / COUNT_PER_PAGE;
        int remains = totalCount % COUNT_PER_PAGE;
        if (remains>0)
            pages++;
        return ApiPagination.builder()
                .page(pages)
                .count(remains)
                .build();
    }
}
