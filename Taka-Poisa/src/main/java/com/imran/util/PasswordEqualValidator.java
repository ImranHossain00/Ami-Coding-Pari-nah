package com.imran.util;

import com.imran.annotations.PasswordEqual;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

public class PasswordEqualValidator
        implements ConstraintValidator<PasswordEqual, Object> {

    private String first;
    private String second;
    private String message;
    @Override
    public void initialize(PasswordEqual constraint) {
        first = constraint.first();
        second = constraint.second();
        message = constraint.message();
    }

    @Override
    public boolean isValid(Object value,
                           ConstraintValidatorContext context) {
        boolean valid = true;

        try {
            final Object firstO
                    = getValue(value, first);
            final Object secondO
                    = getValue(value, second);
            valid = Objects.equals(firstO, secondO);
        } catch (final Exception ignore) {
            // ignore
        }

        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(first)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }

    private Object getValue(Object o,
                            String firstFiled)
            throws NoSuchFieldException, IllegalAccessException {

        Field field = o.getClass().getDeclaredField(firstFiled);
        field.setAccessible(true);

        return field.get(o);
    }
}
