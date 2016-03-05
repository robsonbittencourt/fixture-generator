package com.fixture.generator.builder;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;
import com.fixture.generator.builder.ClassInformationBuilder;
import com.fixture.generator.builder.PackageBuilder;

public class PackageBuilderTest {

	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;

	@Before
	public void setUp() {
		builder = new PackageBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
	}

	@Test
	public void shouldAddPackageOfOriginClassWithSufixOnGeneratedClass() {
		JavaClassSource generatedSource = builder.build(originClass, classSource);

		assertEquals("com.fixture.generator.base.clazz.fixture", generatedSource.getPackage());
	}

}
