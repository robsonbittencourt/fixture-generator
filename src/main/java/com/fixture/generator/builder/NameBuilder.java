package com.fixture.generator.builder;

import org.apache.commons.lang3.StringUtils;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public class NameBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,
			FixtureConfiguration configuration) {
		classSource.setName(originClass.getSimpleName() + validateSuffix(configuration));
		return classSource;
	}

	private String validateSuffix(FixtureConfiguration configuration) {
		if (StringUtils.isBlank(configuration.getClassNameSuffix())) {
			return "Fixture";
		}

		return configuration.getClassNameSuffix();
	}

}
