package com.fixture.generator.builder;

import java.util.List;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fixture.generator.file.FileBuilder;
import com.fixture.generator.validator.FixtureCandidateValidator;

public class ClassGenerator {

	public void generate(Class<?> originClass, String path) {
		FixtureCandidateValidator validator = new FixtureCandidateValidator();
		validator.validate(originClass);

		JavaClassSource classSource = Roaster.create(JavaClassSource.class);

		List<ClassInformationBuilder> classBuilders = ClassInformationBuildersFactory.get();

		for (ClassInformationBuilder builder : classBuilders) {
			classSource = builder.build(originClass, classSource);
		}

		saveToFile(originClass, classSource, path);
	}

	private void saveToFile(Class<?> originClass, JavaClassSource classSource, String path) {
		new FileBuilder().createFile(originClass.getSimpleName() + "Fixture", path, classSource.toString());
	}

}
