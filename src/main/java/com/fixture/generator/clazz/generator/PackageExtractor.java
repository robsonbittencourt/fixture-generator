package com.fixture.generator.clazz.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class PackageExtractor implements ClassInformationExtractor {

	private static final String PACKAGE_SUFIX = ".fixture";

	@Override
	public JavaClassSource extract(Class<?> originClass, JavaClassSource classSource) {
		classSource.setPackage(originClass.getPackage().getName() + PACKAGE_SUFIX);
		return classSource;
	}

}
