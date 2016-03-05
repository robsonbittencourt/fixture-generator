package com.fixture.generator.clazz.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
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
		JavaClassSource generatedSourceClass = builder.build(originClass, classSource);

		FieldSource<JavaClassSource> baseField = generatedSourceClass.getFields().get(0);
		assertEquals("person", baseField.getName());
		assertEquals("Person", baseField.getType().getName());
		assertEquals("new Person()", baseField.getLiteralInitializer());
	}

}
