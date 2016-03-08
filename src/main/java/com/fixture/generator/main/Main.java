package com.fixture.generator.main;

import java.io.IOException;

import com.fixture.generator.builder.ClassGenerator;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ClassGenerator classGenerator = new ClassGenerator();

		classGenerator.generate(Person.class, "src/test/java/com/fixture/generator/main/fixture");
	}

}
