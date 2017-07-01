package com.utility.generator.commons.annotation;

import org.junit.Test;

import com.utility.generator.clazz.part.GeneratedAnnotation;

public class TestAnnotation implements GeneratedAnnotation {

	@Override
	public Class<? extends java.lang.annotation.Annotation> name() {
		return Test.class;
	}

}
