package com.mvc.func.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JSONController {
	
	@RequestMapping(value="{name}")
	@ResponseBody
	public Shop getShopInJSON(@PathVariable String name) {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"Jeff", "Steven"});
		return shop;
	}
}
