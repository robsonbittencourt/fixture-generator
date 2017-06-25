package com.fixture.generator.fixture;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fixture.generator.base.clazz.Person;
import com.fixture.generator.clazz.part.GeneratedPackage;
import com.fxture.generator.configuration.FixtureConfiguration;

public class FixturePackageTest {

	@Test
	public void shouldReturnPackageNameOfOriginClassWhenNotHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName(null);

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.fixture.generator.base.clazz", fixturePackage.name());
	}

	@Test
	public void shouldReturnConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setPackageName("com.fixture");

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.fixture", fixturePackage.name());
	}

}
