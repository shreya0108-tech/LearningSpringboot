package com.codingshuttle.LearningSpringboot.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidatorImpl implements ConstraintValidator<AgeValidator, Integer> {

    @Override
    public boolean isValid(Integer inputAge, ConstraintValidatorContext arg1) {
        // TODO Auto-generated method stub
        if (inputAge == null) {
            return false;
        }
        return inputAge >= 18 && inputAge <= 60;
    }

}
