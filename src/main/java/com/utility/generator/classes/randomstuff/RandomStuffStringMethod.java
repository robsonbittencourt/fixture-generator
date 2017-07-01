package com.utility.generator.classes.randomstuff;

import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.Collections;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;


public class RandomStuffStringMethod implements GeneratedMethod {

	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public String returnType() {
		return "String";
	}

	@Override
	public String getName() {
		return "getRandomString";
	}

	@Override
	public String getBodyTemplate() {
		return "randomstuff/get-random-string-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		return Collections.emptyMap();
	}

}
