package com.utility.generator.classes.randomstuff.method;

import static java.util.Arrays.asList;

import java.math.BigInteger;
import java.util.List;

import com.utility.generator.clazz.part.GeneratedImport;

public class RandomStuffBigIntegerMethod extends RandomStuffMethod {

	@Override
	public String returnType() {
		return "BigInteger";
	}

	@Override
	public List<GeneratedImport> imports() {
		return asList(new GeneratedImport(BigInteger.class));
	}

}
