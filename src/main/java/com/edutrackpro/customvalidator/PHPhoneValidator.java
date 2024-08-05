package com.edutrackpro.customvalidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface PHPhoneValidator {
	String message() default "*Phone number should start with 639 and should be 12 digits long.";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
