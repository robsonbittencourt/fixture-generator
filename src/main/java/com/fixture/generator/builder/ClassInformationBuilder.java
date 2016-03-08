package com.fixture.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public interface ClassInformationBuilder {

	JavaClassSource build(Class<?> originClass, JavaClassSource classSource, FixtureConfiguration configuration);

}
