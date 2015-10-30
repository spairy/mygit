package com.mvc.func.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value ="/json", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Shop execute2(@RequestBody Shop shop){
		shop.setName("changeName");
		return shop;
	}
	
	@RequestMapping("/index")
	public String showIndex(){
		return "ajax/index";
	}
}
