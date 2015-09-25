package com.mvc.func.springForm;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class FormValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"customer.required.userName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"customer.required.address", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"customer.required.password", "Field name is required.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"customer.required.confirmPassword", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
				"customer.required.sex", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
				"customer.required.favNumber", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "javaSkills", "customer.required.javaSkills","Field name is required.");
		
		Customer cust = (Customer)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "customer.notmatch.password");
		}
		
		if(cust.getFavFramework().length==0){
			errors.rejectValue("favFramework", "customer.required.favFrameworks");
		}

		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "customer.required.country");
		}
		
	}
	
}