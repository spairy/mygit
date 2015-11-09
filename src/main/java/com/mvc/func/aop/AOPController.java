package com.mvc.func.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {

	@Autowired
	IHelloWorldService helloWorldService;

	@RequestMapping(value = "/aop/{name}", method = RequestMethod.GET)
	public String aop(@PathVariable String name, ModelMap map) {
		String returnVal = helloWorldService.sayHello(name);
		map.addAttribute("value", returnVal);
		return "aop/aop";
	}

	public IHelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(IHelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

}
