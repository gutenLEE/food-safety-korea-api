package com.food.foodsafetykoreaapi.domain.api.dto;

/**
 * @author gutenlee
 * @since 2023/01/18
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * MSG : 정상처리되었습니다.
 * CODE : INFO-000
 */
@Data
public class ResultStatusDto {
    @JsonProperty("MSG")
    private String MSG;
    @JsonProperty("CODE")
    private String CODE;
}
