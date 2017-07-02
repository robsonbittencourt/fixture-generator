package com.utility.generator.classes.randomstuff.method;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.List;

import com.utility.generator.clazz.part.GeneratedImport;

public class RandomStuffBigDecimalMethod extends RandomStuffMethod {

	@Override
	public String returnType() {
		return "BigDecimal";
	}

	@Override
	public List<GeneratedImport> imports() {
		return asList(new GeneratedImport(BigDecimal.class));
	}

}
