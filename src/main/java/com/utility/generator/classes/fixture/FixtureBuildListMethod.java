package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedParameter;

public class FixtureBuildListMethod implements GeneratedMethod {
	
	private String className;

	protected FixtureBuildListMethod(Class<?> originClass) {
		className = originClass.getSimpleName();
	}
	
	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public String returnType() {
		return "List<" + className + ">";
	}

	@Override
	public String getName() {
		return "buildList";
	}

	@Override
	public String getBodyTemplate() {
		return "fixture/build-list-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		Map<String, Object> variables = new HashMap<>();

		variables.put("className", className);
		variables.put("fieldName", lowerFirstLetter(className));

		return variables;
	}

	@Override
	public List<GeneratedParameter> getParameters() {
		List<GeneratedParameter> parameters = new ArrayList<>();

		parameters.add(new GeneratedParameter(Integer.class, "amount"));

		return parameters;
	}

}
