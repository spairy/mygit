package com.mvc.func.springForm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/customer")
public class FormController {

	FormValidator formValidator;

	@Autowired
	public FormController(FormValidator formValidator) {
		this.formValidator = formValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initCustomerForm(@ModelAttribute("customer") Customer customer, ModelMap model) {
		Customer cust = customer!=null?customer:new Customer();
		/*cust.setFavFramework(new String[] { "Spring MVC" });
		cust.setSex("M");
		cust.setJavaSkills("Hibernate");
		cust.setSecretValue("I'm hidden value");*/
		model.addAttribute("customer", cust);
		return "springForm/initForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(
			@ModelAttribute("customer") Customer customer,
			BindingResult result, SessionStatus status,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		formValidator.validate(customer, result);
		if (result.hasErrors()) {
			return new ModelAndView("springForm/initForm");
		} else {
			status.setComplete();
			//redirectAttributes.addFlashAttribute("customer", customer);
			//return new ModelAndView("redirect:customer/success");
			redirectAttributes.addFlashAttribute("msg", "add successfully......");
			return new ModelAndView("redirect:customer");
		}
	}
	
	@RequestMapping(value="/success" ,method = RequestMethod.GET)
	public ModelAndView showSuccess(){
		return new ModelAndView("springForm/success");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@ModelAttribute("webFrameworkList")
	public List<String> populateWebFrameworkList() {
		// Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		return webFrameworkList;
	}

	@ModelAttribute("numberList")
	public List<String> populateNumberList() {
		// Data referencing for number radio buttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");
		return numberList;
	}

	@ModelAttribute("javaSkillsList")
	public Map<String, String> populateJavaSkillList() {
		// Data referencing for java skills list box
		Map<String, String> javaSkill = new LinkedHashMap<String, String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		return javaSkill;
	}

	@ModelAttribute("countryList")
	public Map<String, String> populateCountryList() {
		// Data referencing for java skills list box
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		return country;
	}
}
