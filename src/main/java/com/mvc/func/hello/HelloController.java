package com.mvc.func.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.func.log4j.LogAgent;
import com.mvc.func.log4j.LogFactory;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	private static final LogAgent LOG_AGENT = LogFactory.getLogAgent(HelloController.class);
	private static final LogAgent LOG_AGENT2 = LogFactory.getLogAgent(HelloController.class, "logs/special.log");

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String printHello(Model model) {
		model.addAttribute("message", "Default Handler");
		return "hello";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String printHelloTo(@PathVariable String name, ModelMap model) {
		LOG_AGENT.debug("AAA " + new java.util.Date().toString());
		LOG_AGENT.info("BBB " + new java.util.Date().toString());
		LOG_AGENT.error("CCC " + new java.util.Date().toString());

		LOG_AGENT2.debug("AAA2 " + new java.util.Date().toString());
		LOG_AGENT2.info("BBB2 " + new java.util.Date().toString());
		LOG_AGENT2.error("CCC2 " + new java.util.Date().toString());
		model.addAttribute("name", name);
		return "hello";
	}
}
