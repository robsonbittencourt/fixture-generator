package com.fixture.generator.fixture;

import static com.fixture.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.Visibility;

import com.fixture.generator.clazz.part.GeneratedMethod;
import com.fixture.generator.clazz.part.GeneratedParameter;

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
	public String getBody() {
		String fieldName = lowerFirstLetter(className);
		
		String body = "List<" + className + "> " + fieldName + "s = new ArrayList<>();";
		body += "for (int i = 0; i < amount; i++) {";
		body += fieldName + "s.add(this.build());";
		body += "}";
		body += "return " + fieldName + "s;";
		
		return body;
	}

	@Override
	public List<GeneratedParameter> getParameters() {
		List<GeneratedParameter> parameters = new ArrayList<>();

		parameters.add(new GeneratedParameter(Integer.class, "amount"));

		return parameters;
	}

}
