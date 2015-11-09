package com.mvc.func.aop;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService implements IHelloWorldService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello World: " + name;
	}

}
