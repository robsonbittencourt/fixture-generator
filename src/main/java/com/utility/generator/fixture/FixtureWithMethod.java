package com.utility.generator.fixture;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static com.utility.generator.util.Utils.upperFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedParameter;
import com.utility.generator.configuration.FixtureConfiguration;

public class FixtureWithMethod implements GeneratedMethod {

	private Class<?> originClass;
	private FixtureConfiguration configuration;
	private Field field;

	protected FixtureWithMethod(Class<?> originClass, FixtureConfiguration configuration, Field field) {
		this.originClass = originClass;
		this.configuration = configuration;
		this.field = field;
	}

	@Override
	public Visibility visibility() {
		return PUBLIC;
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
	public String getBody() {
		String classField = lowerFirstLetter(originClass.getSimpleName());

		String body = "this." + classField + ".set" + upperFirstLetter(field.getName()) + "(" + field.getName() + ");";
		body += "return this;";
		
		return body;
	}

	@Override
	public List<GeneratedParameter> getParameters() {
		List<GeneratedParameter> parameters = new ArrayList<>();

		parameters.add(new GeneratedParameter(field.getType(), field.getName()));

		return parameters;
	}

}