package com.fixture.generator.fixture;


import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;
import com.fixture.generator.clazz.part.GeneratedMethod;

public class FixtureBuildListMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new FixtureBuildListMethod(Person.class);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldReturnAListOfOriginClass() {
		assertEquals("List<Person>", method.returnType());
	}

	@Test
	public void methodNameShoudlBeBuildList() {
		assertEquals("buildList", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		String body = "List<Person> persons = new ArrayList<>();";
		body += "for (int i = 0; i < amount; i++) {";
		body += "persons.add(this.build());";
		body += "}";
		body += "return persons;";

		assertEquals(body, method.getBody());
	}

	@Test
	public void shouldReturnOneParameter() {
		assertEquals(1, method.getParameters().size());
	}

	@Test
	public void shouldReturnAIntegerParameter() {
		assertEquals(Integer.class, method.getParameters().get(0).getType());
	}

	@Test
	public void shouldReturnAParameterWithAmountName() {
		assertEquals("amount", method.getParameters().get(0).getName());
	}

}
