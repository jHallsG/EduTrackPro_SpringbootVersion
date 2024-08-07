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
@Constraint(validatedBy = PasswordValidator.class)
public @interface CharPasswordNotBlankValidator {
	String message() default "*Password must not be blank and must be atleast 8 characters long";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
