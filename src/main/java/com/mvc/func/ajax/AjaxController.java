package com.mvc.func.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@RequestMapping(value = "/{name}", method=RequestMethod.PUT)
	@ResponseBody
	public Shop execute(@PathVariable String name) {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "Jeff", "Steven" });
		return shop;
	}
	
	@RequestMapping("/index")
	public String showIndex(){
		return "ajax/index";
	}
}
