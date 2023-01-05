package com.food.foodsafetykoreaapi.domain.rawmaterial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
@Entity
public class RawMaterial {

    @Id @GeneratedValue
    private Long rawMaterialId;

    private String rawMaterialName;
}
