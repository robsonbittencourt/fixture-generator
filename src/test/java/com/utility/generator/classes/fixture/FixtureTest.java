package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.RandomFields;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class FixtureTest {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		generatedClass = new Fixture(RandomFields.class, new Configuration());
	}

	@Test
	public void shouldReturnFixturePackageAsPackage() {
		GeneratedPackage generatedPackage = generatedClass.packagge();

		assertTrue(generatedPackage instanceof FixturePackage);
	}

	@Test
	public void shouldReturnTheCorrectImports() {
		List<GeneratedImport> generatedImports = generatedClass.imports();

		assertEquals(3, generatedImports.size());
		assertEquals("java.util.List", generatedImports.get(0).qualifiedName());
		assertEquals("java.util.ArrayList", generatedImports.get(1).qualifiedName());
		assertEquals("com.utility.generator.base.clazz.RandomFields", generatedImports.get(2).qualifiedName());
	}

	@Test
	public void classNameShouldBeTheNameOfOriginClassWithConfiguredSuffix() {
		assertEquals("RandomFieldsFixture", generatedClass.name());
	}

	@Test
	public void classShouldHaveOneField() {
		assertEquals(1, generatedClass.fields().size());
	}

	@Test
	public void shouldReturnAListWithFixtureBaseField() {
		GeneratedField generatedField = generatedClass.fields().get(0);

		assertTrue(generatedField instanceof FixtureBaseField);
	}

	@Test
	public void shouldNotHaveAnyConstructors() {
		assertTrue(generatedClass.constructors().isEmpty());
	}

	@Test
	public void shouldReturnThePathWithOriginClassPackageNameWhenDoNotHavePackageNameInConfiguration() {
		assertEquals("src/test/java/com/utility/generator/base/clazz", generatedClass.classFilePath());
	}

	@Test
	public void shouldReturnThePathWithConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setPackageName("com.generator");

		generatedClass = new Fixture(RandomFields.class, configuration);

		assertEquals("src/test/java/com/generator", generatedClass.classFilePath());
	}

}
