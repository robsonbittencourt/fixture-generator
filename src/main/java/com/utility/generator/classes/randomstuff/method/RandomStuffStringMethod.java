package com.utility.generator.classes.randomstuff.method;

public class RandomStuffStringMethod extends RandomStuffMethod {

	@Override
	public String returnType() {
		return "String";
	}

	@Override
	public String getName() {
		return "getRandomString";
	}

	@Override
	public String getBodyTemplate() {
		return "randomstuff/get-random-string-method.vm";
	}

}
