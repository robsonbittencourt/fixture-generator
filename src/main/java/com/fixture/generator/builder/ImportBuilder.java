package com.fixture.generator.builder;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public class ImportBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,
			FixtureConfiguration configuration) {
		classSource.addImport(originClass.getPackage().getName() + "." + originClass.getSimpleName());
		classSource.addImport(List.class);
		classSource.addImport(ArrayList.class);
		return classSource;
	}

}
