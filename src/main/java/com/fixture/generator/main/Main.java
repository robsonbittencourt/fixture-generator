package com.fixture.generator.main;

import java.io.IOException;

import com.fixture.generator.builder.ClassGenerator;
import com.fxture.generator.configuration.FixtureConfiguration;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FixtureConfiguration config = new FixtureConfiguration();
		config.setMethodPrefix("com");
		
		ClassGenerator classGenerator = new ClassGenerator(config);

		classGenerator.generateFixture(Pais.class);
	}

}
