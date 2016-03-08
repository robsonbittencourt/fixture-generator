package com.fixture.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public class PackageBuilder implements ClassInformationBuilder {

	private static final String PACKAGE_SUFIX = ".fixture";

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,
			FixtureConfiguration configuration) {
		classSource.setPackage(originClass.getPackage().getName() + PACKAGE_SUFIX);
		return classSource;
	}

}
