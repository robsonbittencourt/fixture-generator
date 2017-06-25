package com.utility.generator.fixture;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.FixtureConfiguration;

public class FixturePackageTest {

	@Test
	public void shouldReturnPackageNameOfOriginClassWhenNotHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName(null);

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.utility.generator.base.clazz", fixturePackage.name());
	}

	@Test
	public void shouldReturnConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName("com.fixture");

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.fixture", fixturePackage.name());
	}

}
