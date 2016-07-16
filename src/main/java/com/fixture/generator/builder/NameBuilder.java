package com.fixture.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public class NameBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,	FixtureConfiguration configuration) {
		classSource.setName(originClass.getSimpleName() + "Fixture");
		return classSource;
	}

}
