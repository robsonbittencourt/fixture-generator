package com.fixture.generator.fixture;

import static com.fixture.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import org.jboss.forge.roaster.model.Visibility;

import com.fixture.generator.clazz.part.GeneratedMethod;

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
	public String getBody() {
		String fieldName = lowerFirstLetter(className);

		return "return " + fieldName + ";";
	}

}
