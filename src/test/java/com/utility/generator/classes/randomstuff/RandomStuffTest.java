package com.utility.generator.classes.randomstuff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedImports;
import com.utility.generator.clazz.part.GeneratedPackage;

public class RandomStuffTest {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		generatedClass = new RandomStuff();
	}

	@Test
	public void shouldReturnRandomStuffPackageAsPackage() {
		GeneratedPackage generatedPackage = generatedClass.packagge();

		assertTrue(generatedPackage instanceof RandomStuffPackage);
	}

	@Test
	public void shouldReturnRandomStuffImportsAsImports() {
		GeneratedImports generatedImports = generatedClass.imports();

		assertTrue(generatedImports instanceof RandomStuffImports);
	}

	@Test
	public void classNameShouldBeRandomStuff() {
		assertEquals("RandomStuff", generatedClass.name());
	}

	@Test
	public void classShouldNotHaveHaveAnyField() {
		assertTrue(generatedClass.fields().isEmpty());
	}

	@Test
	public void shouldNotHaveAnyConstructors() {
		assertTrue(generatedClass.constructors().isEmpty());
	}

	@Test
	public void classShouldHaveTwoMethods() {
		assertEquals(2, generatedClass.methods().size());
	}

	@Test
	public void shouldReturnTheConfiguredPathToClass() {
		assertEquals("src/test/java/com/utility/generator/randomstuff", generatedClass.classFilePath());
	}

}
