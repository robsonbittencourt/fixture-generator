package com.fixture.generator.clazz.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class BaseFixtureBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource) {
		String className = originClass.getSimpleName();
		String fieldName = Character.toLowerCase(className.charAt(0)) + className.substring(1);

		classSource.addField().setName(fieldName).setType(className).setPrivate().setStatic(true)
				.setLiteralInitializer("new " + className + "()");

		classSource.addMethod().setPublic().setStatic(true).setReturnType(className + "Fixture").setName("get")
				.setBody("return new " + className + "Fixture();");

		classSource.addMethod().setPublic().setReturnType(className).setName("build")
				.setBody("return " + fieldName + ";");

		String body = "List<" + className + ">" + fieldName + "s = new ArrayList<" + className + ">();\n";
		body += "for (int i = 0; i < amount; i++) {\n";
		body += fieldName + "s.add(this.build());\n";
		body += "}\n";
		body += " return " + fieldName + "s;\n";

		classSource.addMethod().setPublic().setReturnType("List<" + className + ">").setName("buildList").setBody(body)
				.addParameter(Integer.class, "amount");

		return classSource;

	}

}
