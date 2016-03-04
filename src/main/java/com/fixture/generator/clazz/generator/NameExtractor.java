package com.fixture.generator.clazz.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class NameExtractor implements ClassInformationExtractor {

	@Override
	public JavaClassSource extract(Class<?> originClass, JavaClassSource classSource) {
		classSource.setName(originClass.getSimpleName() + "Fixture");
		return classSource;
	}

}
