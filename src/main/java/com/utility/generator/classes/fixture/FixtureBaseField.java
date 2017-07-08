package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PRIVATE;

import org.jboss.forge.roaster.model.Visibility;

import com.utility.generator.clazz.part.GeneratedField;

public class FixtureBaseField implements GeneratedField {
	
	private String className;
	
	protected FixtureBaseField(Class<?> originClass) {
		className = originClass.getSimpleName();
	}
	
	@Override
	public Visibility visibility() {
		return PRIVATE;
	}

	@Override
	public String type() {
		return className;
	}

	@Override
	public String name() {
		return lowerFirstLetter(className);
	}

	@Override
	public String value() {
		return "new " + className + "()";
	}

}
