package com.edutrackpro.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<CharPasswordNotBlankValidator, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return ( value != null && value.length() >= 8);
	}
}
