package com.food.foodsafetykoreaapi.domain.product;

import com.food.foodsafetykoreaapi.domain.api.dto.I1250ResponseData;
import com.food.foodsafetykoreaapi.domain.product.enums.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gutenlee
 * @since 2023/02/01
 */
public class Products {

    private List<I1250ResponseData> i1250ResponseDatas = new ArrayList<>();

    public Products(List<I1250ResponseData> i1250ResponseDatas) {
        this.i1250ResponseDatas = i1250ResponseDatas;
    }


    public List<Product> toProductList() {
        return i1250ResponseDatas.stream()
                .map(this::toProduct)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private Product toProduct(I1250ResponseData i1250ResponseData) {
        return Product.builder()
                .prmsDate(i1250ResponseData.getPRMS_DT())
                .productType(ProductType.FOOD)
                .productReportNo(i1250ResponseData.getPRDLST_REPORT_NO())
                .build();
    }
}
