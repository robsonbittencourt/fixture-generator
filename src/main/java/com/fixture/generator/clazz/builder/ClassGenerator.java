package com.fixture.generator.clazz.builder;

import java.util.List;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fixture.generator.file.FileBuilder;

public class ClassGenerator {

	public void generate(Class<?> originClass) {
		JavaClassSource classSource = Roaster.create(JavaClassSource.class);

		List<ClassInformationBuilder> classBuilders = ClassInformationBuildersFactory.get();

		for (ClassInformationBuilder builder : classBuilders) {
			classSource = builder.build(originClass, classSource);
		}

		saveToFile(originClass, classSource);
	}

	private void saveToFile(Class<?> originClass, JavaClassSource classSource) {
		String path = originClass.getPackage().getName().replace(".", "/");

		new FileBuilder().createFile(originClass.getSimpleName() + "Fixture", path + "/fixture",
				classSource.toString());
	}

}
