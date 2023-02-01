package com.food.foodsafetykoreaapi.domain.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2023/02/01
 */
@Entity
public class ProductInfo {

    @Id @GeneratedValue
    private Long productInfoId;
    private Long productId;
}
