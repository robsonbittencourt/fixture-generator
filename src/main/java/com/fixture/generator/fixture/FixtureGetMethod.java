package com.fixture.generator.fixture;

import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import org.jboss.forge.roaster.model.Visibility;

import com.fixture.generator.clazz.part.GeneratedMethod;

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
	public String getBody() {
		return "return new " + className + "Fixture();";
	}

}
