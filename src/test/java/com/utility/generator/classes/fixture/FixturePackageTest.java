package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class FixturePackageTest {

	@Test
	public void shouldReturnPackageNameOfOriginClassWhenNotHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setPackageName(null);

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.utility.generator.base.clazz", fixturePackage.name());
	}

	@Test
	public void shouldReturnConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setPackageName("com.utility");

		GeneratedPackage fixturePackage = new FixturePackage(Person.class, configuration);

		assertEquals("com.utility", fixturePackage.name());
	}

}
