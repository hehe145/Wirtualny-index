package com.app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IllegalNumberValidator.class)
public @interface IllegalNumber {

    String message() default "Numer musi mieć 9 znaków";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
