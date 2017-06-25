package com.fixture.generator.clazz.part;

import java.util.Collections;
import java.util.List;

import org.jboss.forge.roaster.model.Visibility;

public interface GeneratedMethod {
	
	Visibility visibility();
	
	default boolean isStatic() {
		return false;
	}

	String returnType();

	String getName();

	String getBody();

	default List<GeneratedParameter> getParameters() {
		return Collections.emptyList();
	}
	
}
