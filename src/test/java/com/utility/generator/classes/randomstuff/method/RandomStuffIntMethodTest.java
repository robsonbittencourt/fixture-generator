package com.utility.generator.classes.randomstuff.method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.classes.randomstuff.method.RandomStuffIntMethod;
import com.utility.generator.clazz.part.GeneratedMethod;

public class RandomStuffIntMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new RandomStuffIntMethod();
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldBeStatic() {
		assertTrue(method.isStatic());
	}

	@Test
	public void shouldReturnInt() {
		assertEquals("int", method.returnType());
	}

	@Test
	public void methodNameShoudlGetRandomInt() {
		assertEquals("getRandomInt", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		assertEquals("return RandomUtils.nextInt();", method.body());
	}

}
