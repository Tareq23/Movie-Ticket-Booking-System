package com.tareq23.movieticket.validation;

import jakarta.validation.ConstraintValidator;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;

public class AtLeastOneOfValidator implements ConstraintValidator<AtLeastOneOf, Object> {

    private String[] fields;

    @Override
    public void initialize(AtLeastOneOf constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object value, jakarta.validation.ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }

        for(String fieldName : fields){
            try{
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(value);
                if(fieldValue != null && !String.valueOf(fieldValue).trim().isEmpty()){
                    return true;
                }
            }catch (NoSuchFieldException | IllegalAccessException e){
                continue;
            }
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addConstraintViolation();

        return false;
    }
}
