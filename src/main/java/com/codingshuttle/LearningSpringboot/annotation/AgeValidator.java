package com.codingshuttle.LearningSpringboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AgeValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AgeValidator {
    String message() default "Age must be between 18 and 60";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}