package com.utility.generator.classes.randomstuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

import com.utility.generator.classes.randomstuff.method.RandomStuffBigDecimalMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffBigIntegerMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffBooleanMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffDateMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffDoubleMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffFloatMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffIntMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffIntegerMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffLocalDateMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffLongMethod;
import com.utility.generator.classes.randomstuff.method.RandomStuffStringMethod;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class RandomStuff extends AbstractGeneratedClass {

	private Configuration configuration;

	public RandomStuff(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public GeneratedPackage packagge() {
		return new RandomStuffPackage();
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();

		imports.add(new GeneratedImport(Random.class));
		imports.add(new GeneratedImport(RandomUtils.class));

		return imports;
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
		methods.add(new RandomStuffIntegerMethod());
		methods.add(new RandomStuffDoubleMethod());
		methods.add(new RandomStuffStringMethod());
		methods.add(new RandomStuffBigDecimalMethod());
		methods.add(new RandomStuffBigIntegerMethod());
		methods.add(new RandomStuffBooleanMethod());
		methods.add(new RandomStuffDateMethod());
		methods.add(new RandomStuffLocalDateMethod());
		methods.add(new RandomStuffFloatMethod());
		methods.add(new RandomStuffLongMethod());

		return methods;
	}

	@Override
	public String classFilePath() {
		return configuration.getRootPath() + "com/utility/generator/randomstuff";
	}

}
