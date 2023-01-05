package com.food.foodsafetykoreaapi.domain.api;

import com.food.foodsafetykoreaapi.domain.BaseEntity;
import com.food.foodsafetykoreaapi.domain.api.enums.FoodSafetyApiType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
@Entity
@Table
public class ApiRequestHistory extends BaseEntity {

    @Id
    private Long requestId;

    private String searchParameter;

    private FoodSafetyApiType apiType;

    private LocalDate requestDate;

    private Integer requestPage;

    private Integer totalCount;

}
