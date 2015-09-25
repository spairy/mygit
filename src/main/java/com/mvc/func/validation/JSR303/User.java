package com.mvc.func.validation.JSR303;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class User {
	
	@NotEmpty
	// make sure name is not empty
	String name;

	@Range(min = 1, max = 150)
	// age need between 1 and 150
	int age;

	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

}
