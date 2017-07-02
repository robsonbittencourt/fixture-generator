package com.utility.generator.classes.randomstuff.method;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.utility.generator.clazz.part.GeneratedImport;

public class RandomStuffLocalDateMethod extends RandomStuffMethod {

	@Override
	public String returnType() {
		return "LocalDate";
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();

		imports.add(new GeneratedImport(ZoneId.class));
		imports.add(new GeneratedImport(LocalDate.class));
		imports.add(new GeneratedImport(Period.class));

		return imports;
	}

}
