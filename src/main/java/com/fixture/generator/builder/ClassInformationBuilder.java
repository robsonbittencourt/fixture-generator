package com.fixture.generator.builder;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface ClassInformationBuilder {

	JavaClassSource build(Class<?> originClass, JavaClassSource classSource);

}
