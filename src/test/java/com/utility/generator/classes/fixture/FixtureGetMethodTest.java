
package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedMethod;

public class FixtureGetMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new FixtureGetMethod(Person.class);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldBeStatic() {
		assertTrue(method.isStatic());
	}

	@Test
	public void shouldReturnOriginClassWithFixtureSuffix() {
		assertEquals("PersonFixture", method.returnType());
	}

	@Test
	public void methodNameShoudlBeGet() {
		assertEquals("get", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		assertEquals("return new PersonFixture();", method.body());
	}

}
