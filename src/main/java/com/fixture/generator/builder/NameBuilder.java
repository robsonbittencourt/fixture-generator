package com.fixture.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class NameBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource) {
		classSource.setName(originClass.getSimpleName() + "Fixture");
		return classSource;
	}

}
