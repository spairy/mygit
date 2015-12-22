package com.mvc.func.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/interceptor")
public class TestController {

	@RequestMapping(value = { "/index", "" })
	@ResponseBody
	public Shop getShopInJSON() {
		Shop shop = new Shop();
		shop.setName("nxxx");
		shop.setStaffName(new String[]{"Jeff", "Steven"});
		shop.setCode("ERR_SYSTEM_001");
		return shop;
	}

	@RequestMapping("/auth")
	public String auth(@RequestParam String username, HttpServletRequest req) {
		req.getSession().setAttribute("loginUser", username);
		return "redirect:/index";
	}

	@RequestMapping("/out")
	public String out(HttpServletRequest req) {
		req.getSession().removeAttribute("loginUser");
		return "redirect:/login";
	}
}
