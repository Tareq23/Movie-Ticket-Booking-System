package com.tareq23.movieticket.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE,  ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AtLeastOneOfValidator.class)
public @interface AtLeastOneOf {

    String message() default "At least one of the specified fields must be provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] fields();

}
