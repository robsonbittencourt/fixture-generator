package com.fixture.generator.clazz.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface ClassInformationExtractor {

	JavaClassSource extract(Class<?> originClass, JavaClassSource classSource);

}
