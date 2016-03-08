package com.fixture.generator.validator;

import static com.fixture.generator.util.Utils.hasSetMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.fixture.generator.exception.FixtureGeneratorException;

public class FixtureCandidateValidator {

	public void validate(Class<?> clazz) {
		hasParameterlessPublicConstructor(clazz);
		hasPropertyWithSetMethod(clazz);
	}

	private void hasParameterlessPublicConstructor(Class<?> clazz) {
		boolean hasParameterlessPublicConstructor = false;

		for (Constructor<?> constructor : clazz.getConstructors()) {
			if (constructor.getParameterCount() == 0) {
				hasParameterlessPublicConstructor = true;
			}
		}

		if (!hasParameterlessPublicConstructor) {
			throw new FixtureGeneratorException("Class does not contain at least one constructor without parameters");
		}
	}

	private void hasPropertyWithSetMethod(Class<?> clazz) throws FixtureGeneratorException {
		boolean hasPropertyWithSetMethod = false;

		for (Field field : clazz.getDeclaredFields()) {
			hasPropertyWithSetMethod = hasSetMethod(clazz, field);
		}

		if (!hasPropertyWithSetMethod) {
			throw new FixtureGeneratorException("Class does not contain at least one property to set method");
		}
	}

}
