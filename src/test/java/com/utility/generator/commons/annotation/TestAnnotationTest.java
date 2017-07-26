package com.utility.generator.commons.annotation;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;

import org.junit.Test;

import com.utility.generator.commons.annotation.TestAnnotation;

public class TestAnnotationTest {

	@Test
	public void shouldReturnJunitOrgTestAnnotation() {
		TestAnnotation testAnnotation = new TestAnnotation();

		Class<? extends Annotation> annotation = testAnnotation.name();

		assertEquals(Test.class, annotation);
	}

}
