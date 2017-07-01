package com.utility.generator.mappertester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.FixtureConfiguration;

public class MapperTesterPackageTest {

	@Test
	public void shouldReturnPackageNameOfOriginClassWhenNotHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName(null);

		GeneratedPackage fixturePackage = new MapperTesterPackage(SimpleMapper.class, configuration);

		assertEquals("com.utility.generator.base.clazz", fixturePackage.name());
	}

	@Test
	public void shouldReturnConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName("com.utility");

		GeneratedPackage fixturePackage = new MapperTesterPackage(SimpleMapper.class, configuration);

		assertEquals("com.utility", fixturePackage.name());
	}

}
