package com.food.foodsafetykoreaapi.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdDateTime;
    private LocalDateTime lastModifiedDateTime;
}
