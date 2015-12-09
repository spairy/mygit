package com.mvc.func.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
public class HelloWorldWS {
	@Autowired
	IHelloWorldImpl helloWorld;

	@WebMethod(exclude = true)
	public void setHelloWorld(IHelloWorldImpl helloWorld) {
		this.helloWorld = helloWorld;
	}

	@WebMethod(operationName = "sayHelloWorld")
	public String sayHelloWorldNormal() {
		return helloWorld.sayHelloWorld();
	}

}
