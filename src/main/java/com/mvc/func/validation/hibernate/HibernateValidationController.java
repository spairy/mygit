package com.mvc.func.validation.hibernate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/validation/hibernate")
public class HibernateValidationController {
	@Autowired
	ValidationHelper validationHelper;
	
	/*@Autowired
	public HibernateValidationController(ValidationHelper validationHelper) {
		this.validationHelper = validationHelper;
	}
	*/
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.addAttribute("order", new Order());
		return "validation/hibernate/initForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addOrder(@ModelAttribute("order") Order order,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		List<ErrorInfo> errorsList = validationHelper.doValidate(order);
		if (errorsList.size() != 0) {
			ModelAndView mav = new ModelAndView("validation/hibernate/initForm");
			mav.addObject("errorsList", errorsList);
			return mav;
		} else {
			redirectAttributes.addFlashAttribute("msg", "add successfully......");
			return new ModelAndView("redirect:success");
		}
	}
	
	
	@RequestMapping(value="/success" ,method = RequestMethod.GET)
	public ModelAndView showSuccess(){
		return new ModelAndView("validation/hibernate/success");
	}

	public ValidationHelper getValidationHelper() {
		return validationHelper;
	}

	public void setValidationHelper(ValidationHelper validationHelper) {
		this.validationHelper = validationHelper;
	}
	
	
}
