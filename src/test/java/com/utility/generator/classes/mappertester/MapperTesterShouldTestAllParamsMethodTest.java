package com.utility.generator.classes.mappertester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.ServicePerson;
import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.configuration.Configuration;

public class MapperTesterShouldTestAllParamsMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");

		method = new MapperTesterShouldTestAllParamsMethod(SimpleMapper.class, configuration);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldBeVoid() {
		assertEquals("void", method.returnType());
	}

	@Test
	public void methodNameShouldBeNameConfigured() {
		assertEquals("shouldTestAllParams", method.getName());
	}

	@Test
	public void shouldNotHaveParameters() {
		assertTrue(method.getParameters().isEmpty());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		StringBuilder builder = new StringBuilder();

		builder.append("Person entity = new Person();\n\n");
		builder.append("    entity.setAge(getRandomInt());\n");
		builder.append("    entity.setRandomFields(getRandomRandomFields());\n");
		builder.append("    entity.setName(getRandomString());\n\n");
		builder.append("ServicePerson type = new SimpleMapper().toType(entity);\n");
		builder.append("    assertEquals(entity.getAge(), type.getAge());\n");
		builder.append("    assertEquals(entity.getRandomFields(), type.getRandomFields());\n");
		builder.append("    assertEquals(entity.getName(), type.getName());\n");

		assertEquals(builder.toString(), method.body());
	}

}
