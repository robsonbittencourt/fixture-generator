package com.utility.generator.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.builder.ClassInformationBuilder;
import com.utility.generator.builder.NameBuilder;
import com.utility.generator.configuration.FixtureConfiguration;

public class NameBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;
	private FixtureConfiguration fixtureConfiguration;

	@Before
	public void setUp() {
		builder = new NameBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
		fixtureConfiguration = new FixtureConfiguration();
	}

	@Test
	public void shouldSetNameOfGeneratedClassWithNameOfOriginClassWithFixtureSufix() {
		JavaClassSource generatedSource = builder.build(originClass, classSource, fixtureConfiguration);

		assertEquals("PersonFixture", generatedSource.getCanonicalName());
	}

}
