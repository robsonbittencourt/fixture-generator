package com.utility.generator.classes.mappertester;

import static com.utility.generator.util.Utils.extractSetters;
import static com.utility.generator.util.Utils.upperFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedAnnotation;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.commons.annotation.TestAnnotation;
import com.utility.generator.configuration.Configuration;
import com.utility.generator.randomstuff.RandomStuffCreator;

public class MapperTesterShouldTestAllParamsMethod implements GeneratedMethod {

	private Class<?> originClass;
	private Configuration configuration;

	public MapperTesterShouldTestAllParamsMethod(Class<?> originClass, Configuration configuration) {
		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();

		for (Method setter : extractSetters(configuration.getEntityClass())) {
			Class<?> parameterType = setter.getParameters()[0].getType();

			new RandomStuffCreator().buildImport(parameterType, true, imports);
		}

		return imports;
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
		variables.put("mapper", originClass.getSimpleName());

		return variables;
	}

	private List<MapperTesterEntityFields> buildFields() {
		List<MapperTesterEntityFields> fields = new ArrayList<>();

		for (Method setter : extractSetters(configuration.getEntityClass())) {
			addSettersAsField(setter, fields);
		}

		return fields;
	}

	private void addSettersAsField(Method setter, List<MapperTesterEntityFields> fields) {
		String fieldName = setter.getName().replace("set", "");
		String fieldType = setter.getParameters()[0].getType().getSimpleName();

		fields.add(new MapperTesterEntityFields(fieldName, upperFirstLetter(fieldType)));
	}

}
