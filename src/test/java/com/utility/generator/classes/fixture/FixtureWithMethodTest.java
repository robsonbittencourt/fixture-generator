package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.configuration.Configuration;

public class FixtureWithMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		Class<Person> originClass = Person.class;
		Configuration configuration = new Configuration();
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
	public void methodNameShouldBeMethodPrefixWithFieldName() {
		assertEquals("withAge", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		String body = "this.person.setAge(age);\n";
		body += "return this;";

		assertEquals(body, method.body());
	}

	@Test
	public void shouldReturnOneParameter() {
		assertEquals(1, method.getParameters().size());
	}

	@Test
	public void shouldReturnAParameterWithTheSameTypeOfField() {
		assertEquals(Integer.TYPE, method.getParameters().get(0).getType());
	}

	@Test
	public void shouldReturnAParameterWithTheSameNameOfField() {
		assertEquals("age", method.getParameters().get(0).getName());
	}

}
