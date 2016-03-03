package com.fixture.generator.clazz.generator;

import java.io.IOException;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fixture.generator.file.FileBuilder;

public class ClassGenerator {

	public void generate() throws IOException {
		JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

		javaClass.setPackage("com.fixture.generator.test").setName("LunchFixture");

		javaClass.addImport("com.fixture.generator.base.clazz.Lunch");

		javaClass.addField().setName("lunch").setType("Lunch").setPrivate().setStatic(true)
				.setLiteralInitializer("new Lunch()");

		javaClass.addMethod().setPublic().setStatic(true).setReturnType("LunchFixture").setName("get")
				.setBody("return new LunchFixture();");

		javaClass.addMethod().setPublic().setReturnType("Lunch").setName("build").setBody("return lunch;");

		new FileBuilder().createFile("LunchFixture", javaClass.toString());
	}

}
