package com.fixture.generator.main;

import java.io.IOException;

import com.fixture.generator.base.clazz.Lunch;
import com.fixture.generator.clazz.generator.ClassGenerator;

public class Main {

	public static void main(String[] args) throws IOException {
		ClassGenerator classGenerator = new ClassGenerator();

		classGenerator.generate(Lunch.class);
	}

}
