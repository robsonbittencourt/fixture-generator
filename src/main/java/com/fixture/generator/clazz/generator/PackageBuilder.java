package com.fixture.generator.clazz.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class PackageBuilder implements ClassInformationBuilder {

	private static final String PACKAGE_SUFIX = ".fixture";

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource) {
		classSource.setPackage(originClass.getPackage().getName() + PACKAGE_SUFIX);
		return classSource;
	}

}
