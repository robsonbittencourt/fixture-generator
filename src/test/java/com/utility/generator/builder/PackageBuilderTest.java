package com.utility.generator.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.configuration.FixtureConfiguration;

public class PackageBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;
	private FixtureConfiguration fixtureConfiguration;

	@Before
	public void setUp() {
		builder = new PackageBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
		fixtureConfiguration = new FixtureConfiguration();
	}

	@Test
	public void shouldAddPackageOfOriginClassWithSufixOnGeneratedClass() {
		JavaClassSource generatedSource = builder.build(originClass, classSource, fixtureConfiguration);

		assertEquals("com.utility.generator.base.clazz", generatedSource.getPackage());
	}
	
	@Test
	public void shouldAddPackgeFromConfiguration() {
		fixtureConfiguration.setPackageName("com.test");
		
		JavaClassSource generatedSource = builder.build(originClass, classSource, fixtureConfiguration);
		
		assertEquals("com.test", generatedSource.getPackage());
	}

}
