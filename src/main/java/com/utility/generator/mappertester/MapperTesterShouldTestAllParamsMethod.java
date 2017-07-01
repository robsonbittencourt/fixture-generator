package com.utility.generator.mappertester;

import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedAnnotation;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.commons.annotation.TestAnnotation;
import com.utility.generator.configuration.FixtureConfiguration;


public class MapperTesterShouldTestAllParamsMethod implements GeneratedMethod {

	private FixtureConfiguration configuration;

	public MapperTesterShouldTestAllParamsMethod(FixtureConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public List<GeneratedAnnotation> annotations() {
		List<GeneratedAnnotation> annotations = new ArrayList<>();

		annotations.add(new TestAnnotation());

		return annotations;
	}

	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public String returnType() {
		return "void";
	}

	@Override
	public String getName() {
		return "shouldTestAllParams";
	}

	@Override
	public String getBodyTemplate() {
		return "mappertester/should-test-all-params-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		Map<String, Object> variables = new HashMap<>();

		variables.put("fields", buildFields());
		variables.put("type", configuration.getTypeClass().getSimpleName());
		variables.put("entity", configuration.getEntityClass().getSimpleName());

		return variables;
	}

	private List<MapperTesterEntityFields> buildFields() {
		List<MapperTesterEntityFields> fields = new ArrayList<>();
		
		for (Method entityMethod : configuration.getEntityClass().getDeclaredMethods()) {
			addSettersAsFields(fields, entityMethod);
		}
		
		return fields;
	}

	private void addSettersAsFields(List<MapperTesterEntityFields> fields, Method entityMethod) {
		String name = entityMethod.getName();
		
		if (name.startsWith("set")) {
			String fieldName = name.replace("set", "");
			String fieldType = entityMethod.getParameters()[0].getType().getSimpleName();
			fields.add(new MapperTesterEntityFields(fieldName, fieldType));
		}
	}

}
