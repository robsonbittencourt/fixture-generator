package com.fixture.generator.clazz.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;

public class PackageBuilderTest {

	private ClassInformationBuilder builder;

	@Before
	public void setUp() {
		builder = new PackageBuilder();
	}

	@Test
	public void shouldAddPackageOfOriginClassWithSufixOnGeneratedClass() {
		Class<?> originClass = Person.class;
		JavaClassSource classSource = Roaster.create(JavaClassSource.class);

		JavaClassSource generatedSource = builder.build(originClass, classSource);

		assertEquals("com.fixture.generator.base.clazz.fixture", generatedSource.getPackage());

	}

}
