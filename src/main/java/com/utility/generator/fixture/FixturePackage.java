package com.utility.generator.fixture;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.FixtureConfiguration;

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
