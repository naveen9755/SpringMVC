package com.spr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spr.model.Marksheet;

@Component
public class MarksheetValidator implements Validator {
	
	private final static String ROLL_NUMBER = "rollno";

	@Override
	public boolean supports(Class<?> clazz) {
		return Marksheet.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Marksheet marksheet = (Marksheet) target;
		
		Integer rollno = marksheet.getRollno();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "marksheet.name.empty");
		ValidationUtils.rejectIfEmpty(errors, ROLL_NUMBER, "marksheet.rollno.empty");
		
		if (rollno != null && rollno < 1)
			errors.rejectValue(ROLL_NUMBER, "marksheet.rollno.lessThenOne");

	}

}
