package com.fixture.generator.clazz.builder;

import static com.fixture.generator.util.Utils.lowerFirstLetter;
import static com.fixture.generator.util.Utils.upperFirstLetter;

import java.lang.reflect.Field;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class MethodsBuilder implements ClassInformationBuilder {

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource) {
		String className = originClass.getSimpleName();
		String fixtureName = className + "Fixture";
		String classField = lowerFirstLetter(originClass.getSimpleName());

		for (Field field : originClass.getDeclaredFields()) {
			String fieldName = upperFirstLetter(field.getName());

			String body = createMethodBody(classField, field, fieldName);

			classSource.addMethod().setPublic().setReturnType(fixtureName).setName("with" + fieldName).setBody(body)
					.addParameter(field.getType(), field.getName());
		}

		return classSource;
	}

	private String createMethodBody(String classField, Field field, String fieldName) {
		String body = "this." + classField + ".set" + fieldName + "(" + field.getName() + "); \n";
		body += "return this;";
		return body;
	}

}
