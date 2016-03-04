package com.fixture.generator.clazz.generator;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class ImportExtractor implements ClassInformationExtractor {

	@Override
	public JavaClassSource extract(Class<?> originClass, JavaClassSource classSource) {
		classSource.addImport(originClass.getPackage().getName() + "." + originClass.getSimpleName());
		classSource.addImport(List.class);
		classSource.addImport(ArrayList.class);
		return classSource;
	}

}
