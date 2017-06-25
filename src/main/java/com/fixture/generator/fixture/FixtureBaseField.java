package com.fixture.generator.fixture;

import static com.fixture.generator.util.Utils.lowerFirstLetter;
import static org.jboss.forge.roaster.model.Visibility.PUBLIC;

import org.jboss.forge.roaster.model.Visibility;

import com.fixture.generator.clazz.part.GeneratedField;

public class FixtureBaseField implements GeneratedField {
	
	private String className;
	
	protected FixtureBaseField(Class<?> originClass) {
		className = originClass.getSimpleName();
	}
	
	@Override
	public Visibility visibility() {
		return PUBLIC;
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
