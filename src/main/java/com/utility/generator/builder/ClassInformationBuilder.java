package com.utility.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.utility.generator.configuration.FixtureConfiguration;

public interface ClassInformationBuilder {

	JavaClassSource build(Class<?> originClass, JavaClassSource classSource, FixtureConfiguration configuration);

}
