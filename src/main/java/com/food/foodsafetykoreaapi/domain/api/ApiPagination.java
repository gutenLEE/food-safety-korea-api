package com.food.foodsafetykoreaapi.domain.api;

import com.food.foodsafetykoreaapi.exceptions.ExceedPageException;
import com.food.foodsafetykoreaapi.service.api.ApiPageable;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

/**
 * @author gutenlee
 * @since 2023/01/19
 */
@Value
@ToString
public class ApiPagination {

    private final Integer page;
    private final Integer count;

    @Builder
    public ApiPagination(Integer page, Integer count) {
        this.page = page;
        this.count = count;
    }

    public ApiPagination getNextPage(int responseDataCount) {
        if (hasMore(responseDataCount)) {
            return ApiPagination.builder()
                    .page(page + 1)
                    .count(count)
                    .build();
        }

        throw new ExceedPageException("No more page Left");
    }

    private boolean hasMore(int responseDataCount){
        return count == responseDataCount;
    }

    public String getPage() {
        return Integer.toString(page);
    }

    public String getCount() {
        return Integer.toString(count);
    }

    public static ApiPagination initPage(int countPerPage){
        return ApiPagination.builder().page(1).count(countPerPage).build();
    }


}
