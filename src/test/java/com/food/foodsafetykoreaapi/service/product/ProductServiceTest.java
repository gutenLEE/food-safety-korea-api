package com.food.foodsafetykoreaapi.service.product;

import com.food.foodsafetykoreaapi.common.RestTemplateComponent;
import com.food.foodsafetykoreaapi.domain.api.ApiPagination;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.I1250ResponseData;
import com.food.foodsafetykoreaapi.domain.api.dto.RequestParamDto;
import com.food.foodsafetykoreaapi.domain.product.Product;
import com.food.foodsafetykoreaapi.domain.product.Products;
import com.food.foodsafetykoreaapi.exceptions.ExceedPageException;
import com.food.foodsafetykoreaapi.service.api.I1250RestApiService;
import com.food.foodsafetykoreaapi.service.api.RestTemplateRequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@WebServiceClientTest()
@Import(RestTemplateComponent.class)
class ProductServiceTest {

    @Autowired
    RestTemplateComponent restTemplateComponent;

    private I1250RestApiService i1250RestApiService = new I1250RestApiService(
            new RestTemplateRequestService<>(RestTemplateComponent.foodApiRestTemplate())
    );

    private ProductService productService = new ProductService(i1250RestApiService);


    @Test
    void test() throws Exception {
        RequestParamDto requestParamDto = new RequestParamDto();
        requestParamDto.companyName="노바렉스";
        requestParamDto.apiType = "I1250";

        ApiPagination pagination = i1250RestApiService.createPagination(20);

        while (true) {
            ApiResponseDto<I1250ResponseData> responseDto = null;
            try {
                responseDto =
                        i1250RestApiService.request(requestParamDto, pagination);
                pagination = pagination.getNextPage(responseDto.getTotalCount());
            } catch (ExceedPageException e){
                System.out.println("종료");
                break;
            }

            if (!responseDto.isOk())
                break;

            System.out.println("responseDto = " + responseDto);
//            Products products = new Products(rows);
//            List<Product> productList = products.toProductList();
        }
    }


}