package com.fixture.generator.builder;

import static com.fixture.generator.util.Utils.lowerFirstLetter;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.fxture.generator.configuration.FixtureConfiguration;

public class BaseFixtureBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,
			FixtureConfiguration configuration) {
		String className = originClass.getSimpleName();
		String fieldName = lowerFirstLetter(className);

		createBaseField(classSource, className, fieldName);
		createGetMethod(classSource, className);
		createBuildMethod(classSource, className, fieldName);
		createBuildListMethod(classSource, className, fieldName);

		return classSource;

	}

	private void createBaseField(JavaClassSource classSource, String className, String fieldName) {
		classSource.addField().setName(fieldName).setType(className).setPrivate()
				.setLiteralInitializer("new " + className + "()");
	}

	private void createGetMethod(JavaClassSource classSource, String className) {
		classSource.addMethod().setPublic().setStatic(true).setReturnType(className + "Fixture").setName("get")
				.setBody("return new " + className + "Fixture();");
	}

	private void createBuildMethod(JavaClassSource classSource, String className, String fieldName) {
		classSource.addMethod().setPublic().setReturnType(className).setName("build")
				.setBody("return " + fieldName + ";");
	}

	private void createBuildListMethod(JavaClassSource classSource, String className, String fieldName) {
		String body = "List<" + className + ">" + fieldName + "s = new ArrayList<" + className + ">();\n";
		body += "for (int i = 0; i < amount; i++) {\n";
		body += fieldName + "s.add(this.build());\n";
		body += "}\n";
		body += "return " + fieldName + "s;";

		classSource.addMethod().setPublic().setReturnType("List<" + className + ">").setName("buildList").setBody(body)
				.addParameter(Integer.class, "amount");
	}

}
