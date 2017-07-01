package com.utility.generator.fixture;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.HashMap;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;

public class FixtureBuildMethod implements GeneratedMethod {

	private String className;

	protected FixtureBuildMethod(Class<?> originClass) {
		className = originClass.getSimpleName();
	}

	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public String returnType() {
		return className;
	}

	@Override
	public String getName() {
		return "build";
	}

	@Override
	public String getBodyTemplate() {
		return "fixture/build-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		Map<String, Object> variables = new HashMap<>();

		variables.put("fieldName", lowerFirstLetter(className));

		return variables;
	}

}
