package com.fixture.generator.clazz.generator;

import java.util.ArrayList;
import java.util.List;

public class ClassInformationBuildersFactory {

	public static List<ClassInformationBuilder> get() {
		List<ClassInformationBuilder> classBuilders = new ArrayList<>();
		classBuilders.add(new PackageBuilder());
		classBuilders.add(new ImportBuilder());
		classBuilders.add(new NameBuilder());
		classBuilders.add(new BaseFixtureBuilder());

		return classBuilders;
	}

}
