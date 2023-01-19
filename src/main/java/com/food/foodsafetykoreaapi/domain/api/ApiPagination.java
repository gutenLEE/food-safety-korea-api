package com.food.foodsafetykoreaapi.domain.api;

import lombok.Builder;
import lombok.Getter;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
public class ApiPagination {

    private final Integer page;
    private final Integer count;

    @Builder
    public ApiPagination(Integer page, Integer count) {
        this.page = page;
        this.count = count;
    }

    public String getPage() {
        return Integer.toString(page);
    }

    public String getCount() {
        return Integer.toString(count);
    }

    @Override
    public String toString() {
        return "ApiPagination{" +
                "page=" + page +
                ", count=" + count +
                '}';
    }
}
