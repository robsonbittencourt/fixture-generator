package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static com.utility.generator.util.Utils.upperFirstLetter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.configuration.Configuration;
import com.utility.generator.randomstuff.RandomStuffCreator;


public class FixtureWithRandomValueMethod implements GeneratedMethod {

	private Class<?> originClass;
	private Configuration configuration;
	private Field field;

	protected FixtureWithRandomValueMethod(Class<?> originClass, Configuration configuration, Field field) {
		this.originClass = originClass;
		this.configuration = configuration;
		this.field = field;
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();
		
		imports.add(new RandomStuffCreator().buildImport(field.getType(), true));

		return imports;
	}

	@Override
	public Visibility visibility() {
		return Visibility.PUBLIC;
	}

	@Override
	public String returnType() {
		return originClass.getSimpleName() + configuration.getClassNameSuffix();
	}

	@Override
	public String getName() {
		return configuration.getMethodPrefix() + upperFirstLetter(field.getName());
	}

	@Override
	public String getBodyTemplate() {
		return "fixture/with-random-value-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		Map<String, Object> variables = new HashMap<>();

		variables.put("type", upperFirstLetter(field.getType().getSimpleName()));
		variables.put("setName", upperFirstLetter(field.getName()));
		variables.put("classField", lowerFirstLetter(originClass.getSimpleName()));

		return variables;
	}

}
