package com.utility.generator.clazz.part;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.template.VelocityTemplateEngine;

public abstract class GeneratedMethod {

	public abstract Visibility visibility();

	public abstract String returnType();

	public abstract String getName();

	public abstract String getBodyTemplate();

	public abstract Map<String, Object> getBodyTemplateVariables();

	public List<GeneratedAnnotation> annotations() {
		return Collections.emptyList();
	}

	public boolean isStatic() {
		return false;
	}

	public List<GeneratedParameter> getParameters() {
		return Collections.emptyList();
	}

	public String body() {
		VelocityTemplateEngine velocityEngine = new VelocityTemplateEngine();

		return velocityEngine.fillTemplate(getBodyTemplate(), getBodyTemplateVariables());
	}

}
