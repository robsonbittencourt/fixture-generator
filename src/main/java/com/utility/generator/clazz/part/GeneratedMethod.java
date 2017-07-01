package com.utility.generator.clazz.part;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.template.VelocityTemplateEngine;

public interface GeneratedMethod {

	Visibility visibility();

	String returnType();

	String getName();

	String getBodyTemplate();

	Map<String, Object> getBodyTemplateVariables();

	default List<GeneratedAnnotation> annotations() {
		return Collections.emptyList();
	}

	default boolean isStatic() {
		return false;
	}

	default List<GeneratedParameter> getParameters() {
		return Collections.emptyList();
	}

	default String body() {
		VelocityTemplateEngine velocityEngine = new VelocityTemplateEngine();

		return velocityEngine.fillTemplate(getBodyTemplate(), getBodyTemplateVariables());
	}

}
