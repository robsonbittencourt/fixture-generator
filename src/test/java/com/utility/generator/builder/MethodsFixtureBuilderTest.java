package com.utility.generator.builder;

import static com.utility.generator.util.Utils.upperFirstLetter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.builder.ClassInformationBuilder;
import com.utility.generator.builder.ImportBuilder;
import com.utility.generator.builder.MethodsFixtureBuilder;
import com.utility.generator.configuration.FixtureConfiguration;

public class MethodsFixtureBuilderTest {
	private ClassInformationBuilder builder;
	private Class<Person> originClass;
	private JavaClassSource classSource;
	private FixtureConfiguration fixtureConfiguration;

	@Before
	public void setUp() {
		builder = new MethodsFixtureBuilder();
		originClass = Person.class;
		classSource = Roaster.create(JavaClassSource.class);
		fixtureConfiguration = new FixtureConfiguration();
		new ImportBuilder().build(originClass, classSource, fixtureConfiguration);
	}

	@Test
	public void shouldAddCreateWithMethodForEachPropertieOfOriginClass() {
		JavaClassSource generatedSource = builder.build(originClass, classSource, fixtureConfiguration);

		for (Field field : originClass.getDeclaredFields()) {
			verifyIfMethodWasCreated(generatedSource, field.getName(), field.getType().getName());
		}
	}

	private void verifyIfMethodWasCreated(JavaClassSource generatedSource, String propertieName, String parameterType) {
		MethodSource<JavaClassSource> method = generatedSource.getMethod("with" + upperFirstLetter(propertieName), parameterType);
		
		assertNotNull(method);
		assertTrue(method.isPublic());
		assertEquals("PersonFixture", method.getReturnType().getName());
		assertEquals(expectedMethodBody(propertieName), method.getBody());
	}

	private Object expectedMethodBody(String propertieName) {
		String body = "this.person.set" + upperFirstLetter(propertieName) + "(" + propertieName + ");\n";
		body += " return this;";
		return body;
	}

}
