package com.mvc.func.ws;

import org.springframework.stereotype.Service;

@Service
public class IHelloWorldImpl implements IHelloWorld {

	@Override
	public String sayHelloWorld() {
		return "JAX-WS + Spring!";
	}

}
