package com.fixture.generator.validator;

import static com.fixture.generator.util.Utils.hasSetMethod;

import java.util.Arrays;

import com.fixture.generator.exception.FixtureGeneratorException;

public class FixtureCandidateValidator {

	public void validate(Class<?> clazz) {
		hasParameterlessPublicConstructor(clazz);
		hasPropertyWithSetMethod(clazz);
	}

	private void hasParameterlessPublicConstructor(Class<?> clazz) {
		boolean hasParameterlessPublicConstructor = Arrays.stream(clazz.getConstructors())
				.anyMatch(c -> c.getParameterCount() == 0);

		if (!hasParameterlessPublicConstructor) {
			throw new FixtureGeneratorException("Class does not contain at least one constructor without parameters");
		}
	}

	private void hasPropertyWithSetMethod(Class<?> clazz) throws FixtureGeneratorException {
		boolean hasPropertyWithSetMethod = Arrays.stream(clazz.getDeclaredFields())
				.anyMatch(f -> hasSetMethod(clazz, f));

		if (!hasPropertyWithSetMethod) {
			throw new FixtureGeneratorException("Class does not contain at least one property to set method");
		}
	}

}
