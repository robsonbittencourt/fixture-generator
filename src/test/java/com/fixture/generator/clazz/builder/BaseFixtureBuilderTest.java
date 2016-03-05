package com.fixture.generator.clazz.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;

public class BaseFixtureBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;

	@Before
	public void setUp() {
		builder = new BaseFixtureBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
		new ImportBuilder().build(originClass, classSource);
	}

	@Test
	public void shouldCreateBaseField() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		FieldSource<JavaClassSource> baseField = generatedSource.getFields().get(0);
		assertEquals("person", baseField.getName());
		assertEquals("Person", baseField.getType().getName());
		assertEquals("new Person()", baseField.getLiteralInitializer());
	}

	@Test
	public void shouldCreateGetMethod() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		MethodSource<JavaClassSource> getMethod = generatedSource.getMethod("get");
		assertNotNull(getMethod);
		assertTrue(getMethod.isPublic());
		assertTrue(getMethod.isStatic());
		assertEquals("PersonFixture", getMethod.getReturnType().getName());
		assertEquals("return new PersonFixture();", getMethod.getBody());
	}

	@Test
	public void shouldCreateBuildMethod() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		MethodSource<JavaClassSource> buildMethod = generatedSource.getMethod("build");
		assertNotNull(buildMethod);
		assertTrue(buildMethod.isPublic());
		assertEquals("Person", buildMethod.getReturnType().getName());
		assertEquals("return person;", buildMethod.getBody());
	}

	@Test
	public void shouldCreateBuildListMethod() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		MethodSource<JavaClassSource> buildListMethod = generatedSource.getMethod("buildList", "Integer");
		assertNotNull(buildListMethod);
		assertTrue(buildListMethod.isPublic());

		assertEquals("List", buildListMethod.getReturnType().getName());
		assertEquals("Person", buildListMethod.getReturnType().getTypeArguments().get(0).getName());
		assertEquals(expectedBody(), buildListMethod.getBody());
	}

	private String expectedBody() {
		String body = "List<Person> persons=new ArrayList<Person>();\n";
		body += " for (int i=0; i < amount; i++) {\n";
		body += "  persons.add(this.build());\n";
		body += "}\n";
		body += " return persons;";
		return body;
	}

}
