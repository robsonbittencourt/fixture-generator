package com.utility.generator.fixture;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.fixture.FixtureBuildMethod;

public class FixtureBuildMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new FixtureBuildMethod(Person.class);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldReturnOriginClass() {
		assertEquals("Person", method.returnType());
	}

	@Test
	public void methodNameShoudlBeBuild() {
		assertEquals("build", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		assertEquals("return person;", method.getBody());
	}

}
