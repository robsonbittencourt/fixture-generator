package com.fixture.generator.builder;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ClassInformationBuildersFactoryTest {

	@Test
	public void shouldCreateAListWithNecessaryBuilder() {
		List<ClassInformationBuilder> builders = ClassInformationBuildersFactory.get();

		assertEquals(5, builders.size());
		assertEquals(PackageBuilder.class, builders.get(0).getClass());
		assertEquals(ImportBuilder.class, builders.get(1).getClass());
		assertEquals(NameBuilder.class, builders.get(2).getClass());
		assertEquals(BaseFixtureBuilder.class, builders.get(3).getClass());
		assertEquals(MethodsBuilder.class, builders.get(4).getClass());
	}

}
