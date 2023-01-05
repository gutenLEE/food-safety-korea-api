package com.food.foodsafetykoreaapi.domain.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
@Entity
public class Product {

    @Id @GeneratedValue
    private Long productId;

    private Long companyId;

    private LocalDate prmsDate;

    private String productReportNo;

    private ProductType productType;
}
