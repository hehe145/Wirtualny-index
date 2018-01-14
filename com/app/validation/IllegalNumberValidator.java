package com.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IllegalNumberValidator implements ConstraintValidator<IllegalNumber, String> {
    @Override
    public void initialize(IllegalNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() < 9) {
            return false;
        }
        return true;
    }
}
