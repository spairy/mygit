package com.mvc.func.validation.JSR303;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/validation/beanValidation")
public class BeanValidationController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "validation/JSR303/initForm";
		} else {
			return "validation/JSR303/success";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayForm(ModelMap model){
		model.addAttribute("user", new User());
		return "validation/JSR303/initForm";
	}
}
