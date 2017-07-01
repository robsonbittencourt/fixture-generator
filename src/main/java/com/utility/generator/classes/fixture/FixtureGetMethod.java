package com.utility.generator.classes.fixture;

import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.HashMap;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;

public class FixtureGetMethod implements GeneratedMethod {

	private String className;

	protected FixtureGetMethod(Class<?> originClass) {
		className = originClass.getSimpleName();
	}

	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public String returnType() {
		return className + "Fixture";
	}

	@Override
	public String getName() {
		return "get";
	}

	@Override
	public String getBodyTemplate() {
		return "fixture/get-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		Map<String, Object> variables = new HashMap<>();

		variables.put("className", className);

		return variables;
	}

}
