package com.utility.generator.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.configuration.FixtureConfiguration;

public class ImportBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;
	private FixtureConfiguration fixtureConfiguration;

	@Before
	public void setUp() {
		builder = new ImportBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
		fixtureConfiguration = new FixtureConfiguration();
	}

	@Test
	public void shouldAddImportForBaseClassAndLists() {
		JavaClassSource generatedSource = builder.build(originClass, classSource, fixtureConfiguration);

		assertEquals("com.utility.generator.base.clazz.Person", generatedSource.getImports().get(0).getQualifiedName());
		assertEquals("java.util.List", generatedSource.getImports().get(1).getQualifiedName());
		assertEquals("java.util.ArrayList", generatedSource.getImports().get(2).getQualifiedName());
	}

}
