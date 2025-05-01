package com.training.training_event_management_system_back.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WhiteSpaceValidator.class)
public @interface WhiteSpaceConstraint {
    String message() default "Field must not contain leading and trailing spaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

