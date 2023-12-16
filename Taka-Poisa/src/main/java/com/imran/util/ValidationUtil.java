package com.imran.util;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// This is an example of singleton pattern
public class ValidationUtil {

    private static final ValidationUtil INSTANCE
            = new ValidationUtil();
    private final Validator validator;
    private ValidationUtil() {
        var validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

    public static ValidationUtil getInstance() {
        return INSTANCE;
    }

    public <T>Map<? super Object, String> validate(T obj) {
        var violations = validator.validate(obj);

        return violations
                .stream()
                .collect(Collectors.toMap(
                        violation ->
                                violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage,
                        (eMsg1, eMsg2) -> eMsg1 + " <br/> " + eMsg2
                ));

//        Map<? super Object, String> errors = new HashMap<>();
//        for (ConstraintViolation<T> violation : violations) {
//            String path = violation.getPropertyPath().toString();
//            if (errors.containsKey(path)) {
//                String eMsg = errors.get(path);
//                errors.put(path, eMsg + " <br/> " + violation.getMessage());
//            } else {
//                errors.put(path, violation.getMessage());
//            }
//        }
//        return errors;
    }
}
