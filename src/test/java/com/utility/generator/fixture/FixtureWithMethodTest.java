package com.utility.generator.fixture;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.configuration.FixtureConfiguration;
import com.utility.generator.fixture.FixtureWithMethod;

public class FixtureWithMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		Class<Person> originClass = Person.class;
		FixtureConfiguration configuration = new FixtureConfiguration();
		Field nameField = originClass.getDeclaredFields()[0];

		method = new FixtureWithMethod(originClass, configuration, nameField);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldReturnOriginClassWithFixtureSuffix() {
		assertEquals("PersonFixture", method.returnType());
	}

	@Test
	public void methodNameShoudlBeMethodPrefixWithFieldName() {
		assertEquals("withName", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		String body = "this.person.setName(name);";
		body += "return this;";

		assertEquals(body, method.getBody());
	}

	@Test
	public void shouldReturnOneParameter() {
		assertEquals(1, method.getParameters().size());
	}

	@Test
	public void shouldReturnAParameterWithTheSameTypeOfField() {
		assertEquals(String.class, method.getParameters().get(0).getType());
	}

	@Test
	public void shouldReturnAParameterWithTheSameNameOfField() {
		assertEquals("name", method.getParameters().get(0).getName());
	}

}
