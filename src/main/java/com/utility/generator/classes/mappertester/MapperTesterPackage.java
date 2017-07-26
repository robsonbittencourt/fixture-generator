package com.utility.generator.classes.mappertester;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;


public class MapperTesterPackage implements GeneratedPackage {

	private Class<?> originClass;
	private Configuration configuration;

	protected MapperTesterPackage(Class<?> originClass, Configuration configuration) {
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
