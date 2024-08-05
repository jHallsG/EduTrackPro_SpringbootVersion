package com.edutrackpro.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PHPhoneValidator, Long>{

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		
		String phone = value.toString();
		
		return (phone.startsWith("639") && phone.length() == 12);
	
	}
}
