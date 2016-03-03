package com.fixture.generator;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ClassGenerator classGenerator = new ClassGenerator();

		classGenerator.generate();
	}

}
