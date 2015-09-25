package com.mvc.func.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String printHello(Model model) {
		model.addAttribute("message", "Default Handler");
		return "hello";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String printHelloTo(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return "hello";
	}
}
