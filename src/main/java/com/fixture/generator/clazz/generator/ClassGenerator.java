package com.fixture.generator.clazz.generator;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fixture.generator.base.clazz.Lunch;
import com.fixture.generator.file.FileBuilder;

public class ClassGenerator {

	public void generate() {
		Class<?> originClass = Lunch.class;
		JavaClassSource classSource = Roaster.create(JavaClassSource.class);

		List<ClassInformationExtractor> extractors = new ArrayList<>();
		extractors.add(new PackageExtractor());
		extractors.add(new ImportExtractor());
		extractors.add(new NameExtractor());
		extractors.add(new BaseFixtureExtractor());

		for (ClassInformationExtractor extractor : extractors) {
			classSource = extractor.extract(originClass, classSource);
		}

		saveToFile(originClass, classSource);
	}

	private void saveToFile(Class<?> originClass, JavaClassSource classSource) {
		String path = originClass.getPackage().getName().replace(".", "/");

		new FileBuilder().createFile(originClass.getSimpleName() + "Fixture", path + "/fixture",
				classSource.toString());
	}

}
