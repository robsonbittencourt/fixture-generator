package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedField;

public class FixtureBaseFieldTest {

	private GeneratedField field;

	@Before
	public void setUp() {
		field = new FixtureBaseField(Person.class);
	}

	@Test
	public void shouldBeAPublicField() {
		assertEquals(Visibility.PUBLIC, field.visibility());
	}

	@Test
	public void typeShouldBeTheSameOfOriginClass() {
		assertEquals("Person", field.type());
	}

	@Test
	public void nameShouldBeTheSameOfOriginClassWithFirstLetterInLowerCase() {
		assertEquals("person", field.name());
	}
	
	@Test
	public void valueShouldBeNewInstanceOfOriginalClass() {
		assertEquals("new Person()", field.value());
	}

}
