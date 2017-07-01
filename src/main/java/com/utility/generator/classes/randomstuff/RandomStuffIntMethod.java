package com.utility.generator.classes.randomstuff;

import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.Collections;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;


public class RandomStuffIntMethod implements GeneratedMethod {

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
		return "int";
	}

	@Override
	public String getName() {
		return "getRandomInt";
	}

	@Override
	public String getBodyTemplate() {
		return "randomstuff/get-random-int-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		return Collections.emptyMap();
	}

}
