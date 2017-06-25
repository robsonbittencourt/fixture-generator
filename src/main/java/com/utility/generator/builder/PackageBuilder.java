package com.utility.generator.builder;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.utility.generator.configuration.FixtureConfiguration;

public class PackageBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource, FixtureConfiguration configuration) {
		classSource.setPackage(buildPackage(originClass, configuration));
		return classSource;
	}

	private String buildPackage(Class<?> originClass, FixtureConfiguration configuration) {
		if (isBlank(configuration.getPackageName())) {
			return originClass.getPackage().getName();
		} else {
			return configuration.getPackageName();
		}
	}

}
