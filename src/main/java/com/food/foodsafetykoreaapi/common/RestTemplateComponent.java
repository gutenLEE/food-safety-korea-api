package com.food.foodsafetykoreaapi.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author gutenlee
 * @since 2023/01/31
 */
@Component
public class RestTemplateComponent {

    @Bean
    public RestTemplate foodApiRestTemplate(){
        return new RestTemplate();
    }
}
