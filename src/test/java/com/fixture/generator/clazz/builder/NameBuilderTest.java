package com.fixture.generator.clazz.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;

public class NameBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;

	@Before
	public void setUp() {
		builder = new NameBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
	}

	@Test
	public void shouldSetNameOfGeneratedClassWithNameOfOriginClassWithFixtureSufix() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		assertEquals("PersonFixture", generatedSource.getCanonicalName());
	}

}
