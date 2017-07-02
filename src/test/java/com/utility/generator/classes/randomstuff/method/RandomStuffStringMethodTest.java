package com.utility.generator.classes.randomstuff.method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.classes.randomstuff.method.RandomStuffStringMethod;
import com.utility.generator.clazz.part.GeneratedMethod;

public class RandomStuffStringMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new RandomStuffStringMethod();
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
	public void shouldReturnString() {
		assertEquals("String", method.returnType());
	}

	@Test
	public void methodNameShoudlGetRandomString() {
		assertEquals("getRandomString", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		StringBuilder expectedBody = new StringBuilder();
		
		expectedBody.append("final Random random = new Random();\n");
		expectedBody.append("final StringBuilder sb = new StringBuilder();\n");
		expectedBody.append("\n");
		expectedBody.append("int stringLength = 10;\n");
		expectedBody.append("\n");
		expectedBody.append("for (int i = 0; i < stringLength; i++) {\n");
		expectedBody.append("	switch (random.nextInt(3)) {\n");
		expectedBody.append("		case 0:\n");
		expectedBody.append("			// 48 = 0, 57 = 9\n");
		expectedBody.append("			sb.append(new Character((char) (48 + random.nextInt((57 + 1 - 48)))));\n");
		expectedBody.append("			break;\n");
		expectedBody.append("		case 1:\n");
		expectedBody.append("			// 97 = a, 122 = z\n");
		expectedBody.append("			sb.append(new Character((char) (97 + random.nextInt((122 + 1 - 97)))));\n");
		expectedBody.append("			break;\n");
		expectedBody.append("		case 2:\n");
		expectedBody.append("			// 65 = A, 90 = Z\n");
		expectedBody.append("			sb.append(new Character((char) (65 + random.nextInt((90 + 1 - 65)))));\n");
		expectedBody.append("			break;\n");
		expectedBody.append("		default:\n");
		expectedBody.append("			break;\n");
		expectedBody.append("	}\n");
		expectedBody.append("}\n");
		expectedBody.append("return sb.toString();");

		assertEquals(expectedBody.toString(), method.body());
	}

}
