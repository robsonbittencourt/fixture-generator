package com.utility.generator.classes.randomstuff.method;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static com.utility.generator.util.Utils.upperFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import java.util.Collections;
import java.util.Map;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedMethod;

public abstract class RandomStuffMethod implements GeneratedMethod {

	@Override
	public Visibility visibility() {
		return PUBLIC;
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public String getName() {
		return "getRandom" + upperFirstLetter(returnType());
	}

	@Override
	public String getBodyTemplate() {
		return "randomstuff/get-random-" + lowerFirstLetter(returnType()) + "-method.vm";
	}

	@Override
	public Map<String, Object> getBodyTemplateVariables() {
		return Collections.emptyMap();
	}

}
