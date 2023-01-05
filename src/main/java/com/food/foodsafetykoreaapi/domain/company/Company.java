package com.food.foodsafetykoreaapi.domain.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2023/01/05
 */
@Entity
@Table
public class Company {

    @Id @GeneratedValue
    private Long companyId;

    private String licenseNo;

    private String companyName;

    private IndustryName industryName;

    private LocalDate prmsDate;

    private String tel;

    private String address;

}
