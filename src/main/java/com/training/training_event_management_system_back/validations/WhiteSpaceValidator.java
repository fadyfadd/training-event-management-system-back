package com.training.training_event_management_system_back.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WhiteSpaceValidator implements ConstraintValidator<WhiteSpaceConstraint, String> {

    @Override
    public void initialize(WhiteSpaceConstraint constraint){
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        return value.trim().equals(value);
    }
}
