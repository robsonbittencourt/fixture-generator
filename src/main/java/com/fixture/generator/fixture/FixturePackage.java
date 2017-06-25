package com.fixture.generator.fixture;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.fixture.generator.clazz.part.GeneratedPackage;
import com.fxture.generator.configuration.FixtureConfiguration;

public class FixturePackage implements GeneratedPackage {
	
	private Class<?> originClass;
	private FixtureConfiguration configuration;

	protected FixturePackage(Class<?> originClass, FixtureConfiguration configuration) {
		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public String name() {
		if (isBlank(configuration.getPackageName())) {
			return originClass.getPackage().getName();
		} else {
			return configuration.getPackageName();
		}
	}
	
}
