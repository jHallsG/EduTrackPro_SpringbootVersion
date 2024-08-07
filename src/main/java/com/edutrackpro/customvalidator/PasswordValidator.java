package com.edutrackpro.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<CharPasswordNotBlankValidator, char[]>{

	@Override
	public boolean isValid(char[] value, ConstraintValidatorContext context) {
		return ( value != null && value.length >= 8);
	}
}
