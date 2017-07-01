package com.utility.generator.clazz.part;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.utility.generator.base.clazz.Person;

public class GeneratedImportTest {

	@Test
	public void shouldReturnQualifiedName() {
		GeneratedImport generatedImport = new GeneratedImport(Person.class);

		assertEquals("com.utility.generator.base.clazz.Person", generatedImport.qualifiedName());
	}

	@Test
	public void shouldReturnStaticAsFalseWhenInformedOnlyClassOnConstructor() {
		GeneratedImport generatedImport = new GeneratedImport(Person.class);

		assertFalse(generatedImport.isStatic());
	}

	@Test
	public void shouldReturnStaticAsTrueWhenInformedStaticTrueOnConstructor() {
		GeneratedImport generatedImport = new GeneratedImport(Person.class, true);

		assertTrue(generatedImport.isStatic());
	}

	@Test
	public void shouldReturnStaticAsFalseWhenInformedStaticFalseOnConstructor() {
		GeneratedImport generatedImport = new GeneratedImport(Person.class, false);

		assertFalse(generatedImport.isStatic());
	}

}
