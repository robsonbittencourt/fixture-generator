package com.fixture.generator.builder;

import java.util.ArrayList;
import java.util.List;

public class ClassInformationBuildersFactory {

	public static List<ClassInformationBuilder> getForFixture() {
		List<ClassInformationBuilder> classBuilders = new ArrayList<>();

		classBuilders.add(new PackageBuilder());
		classBuilders.add(new ImportBuilder());
		classBuilders.add(new NameBuilder());
		classBuilders.add(new BaseFixtureBuilder());
		classBuilders.add(new MethodsFixtureBuilder());

		return classBuilders;
	}
	
	public static List<ClassInformationBuilder> getForMapperTest() {
		List<ClassInformationBuilder> classBuilders = new ArrayList<>();
		
		classBuilders.add(new PackageBuilder());
		classBuilders.add(new ImportBuilder());
		classBuilders.add(new NameBuilder());
		classBuilders.add(new BaseMapperTestBuilder());
		
		return classBuilders;
	}

}
