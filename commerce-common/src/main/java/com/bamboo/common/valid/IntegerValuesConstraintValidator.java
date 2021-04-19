package com.bamboo.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class IntegerValuesConstraintValidator implements ConstraintValidator<ListValues, Integer> {
    volatile Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValues constraintAnnotation) {
        int[] values = constraintAnnotation.values();
        for (int v : values){
            //int 不存在null 所以不判断
            set.add(v);
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }
}
