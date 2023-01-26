package com.food.foodsafetykoreaapi.domain.api;

import com.food.foodsafetykoreaapi.exceptions.ExceedPageException;
import com.food.foodsafetykoreaapi.service.api.RestApiPageable;
import lombok.Builder;
import lombok.ToString;

import java.util.Objects;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
@ToString
public class ApiPagination implements RestApiPageable {

    private static final int COUNT_PER_PAGE = 20;

    private Integer page;

    @Builder
    public ApiPagination(
            Integer page) {
        this.page = page;
    }


    @Override
    public ApiPagination paging(int responseDataCount) {
        if (hasMore(responseDataCount)) {
            this.page++;
            return this;
        }
        throw new ExceedPageException("No more page Left");
    }

    private boolean hasMore(int responseDataCount){
        return COUNT_PER_PAGE == responseDataCount;
    }

    public String getPage() {
        return Integer.toString(page);
    }

    public String getCount() {
        return Integer.toString(COUNT_PER_PAGE);
    }


}
