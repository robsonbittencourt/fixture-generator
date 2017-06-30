package com.utility.generator.mappertest;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.FixtureConfiguration;


public class MapperTestPackage implements GeneratedPackage {

	private Class<?> originClass;
	private FixtureConfiguration configuration;

	protected MapperTestPackage(Class<?> originClass, FixtureConfiguration configuration) {
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
