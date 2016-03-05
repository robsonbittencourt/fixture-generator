package com.fixture.generator.main;

import java.io.IOException;

import com.fixture.generator.builder.ClassGenerator;

public class Main {

	public static void main(String[] args) throws IOException {
		ClassGenerator classGenerator = new ClassGenerator();

		classGenerator.generate(Person.class);
	}

}
