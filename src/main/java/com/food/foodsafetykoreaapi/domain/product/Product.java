package com.food.foodsafetykoreaapi.domain.product;

import com.food.foodsafetykoreaapi.domain.product.enums.ProductType;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
public class Product {

    private Long productId;

    private Long companyId;

    private String prmsDate;

    private String productReportNo;

    private ProductType productType;

    protected Product() {
    }

    @Builder
    public Product(
            Long productId,
            Long companyId,
            String prmsDate,
            String productReportNo,
            ProductType productType
    ) {
        this.productId = productId;
        this.companyId = companyId;
        this.prmsDate = prmsDate;
        this.productReportNo = productReportNo;
        this.productType = productType;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", companyId=" + companyId +
                ", prmsDate='" + prmsDate + '\'' +
                ", productReportNo='" + productReportNo + '\'' +
                ", productType=" + productType +
                '}';
    }
}
