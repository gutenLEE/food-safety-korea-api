package com.food.foodsafetykoreaapi.exceptions;

/**
 * @author gutenlee
 * @since 2023/01/27
 */
public class ExceedPageException extends IllegalStateException {

    public ExceedPageException(String msg) {
        super(msg);
    }
}
