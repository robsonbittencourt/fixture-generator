package com.utility.generator.classes.randomstuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImports;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;

public class RandomStuff extends AbstractGeneratedClass {

	@Override
	public GeneratedPackage packagge() {
		return new RandomStuffPackage();
	}

	@Override
	public GeneratedImports imports() {
		return new RandomStuffImports();
	}

	@Override
	public String name() {
		return "RandomStuff";
	}

	@Override
	public List<GeneratedField> fields() {
		return Collections.emptyList();
	}

	@Override
	public List<GeneratedMethod> methods() {
		List<GeneratedMethod> methods = new ArrayList<>();
		
		methods.add(new RandomStuffIntMethod());
		methods.add(new RandomStuffStringMethod());

		return methods;
	}

	@Override
	public String classFilePath() {
		return "src/test/java/com/utility/generator/randomstuff";
	}

}
