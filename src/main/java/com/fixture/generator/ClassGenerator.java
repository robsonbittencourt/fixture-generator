package com.fixture.generator;

import java.io.IOException;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fixture.generator.file.FileBuilder;

public class ClassGenerator {

	public void generate() throws IOException {
		JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

		javaClass.setPackage("com.fixture.generator").setName("Person");

		javaClass.addProperty(String.class, "firstName");

		new FileBuilder().createFile(javaClass.toString());
	}

}
