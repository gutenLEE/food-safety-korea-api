package com.food.foodsafetykoreaapi.service;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.foodsafetykoreaapi.domain.api.dto.ApiResponseDto;
import com.food.foodsafetykoreaapi.domain.api.dto.C003ResponseData;
import com.food.foodsafetykoreaapi.domain.api.dto.ResponseWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

/**
 * @author gutenlee
 * @since 2023/01/14
 */
public class TestApiServiceImpl implements ApiService {

    @Override
    public void request() {

        // http://openapi.foodsafetykorea.go.kr/api/
        // 09f855f93fb8481da7b5/
        // C003/json/1/1000/
        // BSSH_NM=노바렉스&PRMS_DT=20210101
        String url = "http://openapi.foodsafetykorea.go.kr/api/09f855f93fb8481da7b5/C003/json/1/1/BSSH_NM=노바렉스&PRMS_DT=20210101";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> entity = restTemplate.getForEntity(url, HashMap.class);

        ObjectMapper mapper = new ObjectMapper();



    }
}
