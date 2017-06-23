package com.fixture.generator.builder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Test;

import com.fxture.generator.configuration.FixtureConfiguration;

public class BaseMapperTestBuilder implements ClassInformationBuilder {

	public static String newline = System.getProperty("line.separator");

	@Override
	public JavaClassSource build(Class<?> originClass, JavaClassSource classSource,
			FixtureConfiguration configuration) {
		try {
			Class<?> entity = configuration.getEntityClass();
			Class<?> type = configuration.getTypeClass();

			createAssertMethod("entity", configuration.getMethodName(), entity, type, classSource);
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	private void createAssertMethod(String entityName, String methodName, Class<?> entity, Class<?> type,
			JavaClassSource classSource) {
		List<String> setters = extractSetters("entity", entity);
		List<String> asserts = extractAsserts("entity", entity, "type", type);

		String entityDeclaration = createClassDeclaration("entity", entity);
		String typeDeclaration = createMapperDeclaration("type", type);

		String compiled = compileMethod(entityDeclaration, setters, typeDeclaration, asserts);

		classSource.addMethod().setPublic().setName(methodName).setReturnTypeVoid().setBody(compiled)
				.addAnnotation(Test.class);
	}

	private String compileMethod(String entityDeclaration, List<String> setters, String typeDeclaration,
			List<String> asserts) {
		StringBuilder builder = new StringBuilder();
		builder.append(entityDeclaration);
		setters.forEach(builder::append);
		builder.append(newline);
		builder.append(typeDeclaration);
		builder.append(newline);
		asserts.forEach(builder::append);
		return builder.toString();
	}

	private String createMapperDeclaration(String name, Class<?> type) {
		StringBuilder builder = new StringBuilder();
		builder.append(type.getSimpleName());
		builder.append(" ").append(name);
		builder.append(" = mapper.toType(entity);");
		builder.append(newline);
		return builder.toString();
	}

	private String createClassDeclaration(String name, Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		builder.append(clazz.getSimpleName());
		builder.append(" ").append(name).append(" = new ");
		builder.append(clazz.getSimpleName());
		builder.append("();");
		builder.append(newline);
		return builder.toString();
	}

	private List<String> extractSetters(String entityName, Class<?> entity) {
		List<String> setters = new ArrayList<>();
		for (Method entityMethod : entity.getDeclaredMethods()) {
			String name = entityMethod.getName();
			if (name.startsWith("set")) {
				setters.add(createNewSetter(entityName, entityMethod));
			}
		}
		return setters;
	}

	private String createNewSetter(String entityName, Method entityMethod) {
		StringBuilder buffer = new StringBuilder();
		buffer.append(entityName).append(".").append(entityMethod.getName()).append("(");
		buffer.append("getRandom").append(entityMethod.getParameters()[0].getType().getSimpleName());
		buffer.append("());");
		buffer.append(newline);
		return buffer.toString();
	}

	private List<String> extractAsserts(String entityName, Class<?> entity, String typeName, Class<?> type) {
		List<String> asserts = new ArrayList<>();
		for (Method entityMethod : entity.getDeclaredMethods()) {
			String name = entityMethod.getName();
			if (name.startsWith("get")) {
				try {
					Method typeMethod = type.getDeclaredMethod(name);
					if (typeMethod != null) {
						asserts.add(createNewAssert(entityName, entityMethod, typeName, typeMethod));
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return asserts;
	}

	private String createNewAssert(String entityName, Method entityMethod, String typeName, Method typeMethod) {
		StringBuilder builder = new StringBuilder();
		builder.append("assertEquals(");
		builder.append(entityName).append(".");
		builder.append(entityMethod.getName()).append("(), ");
		builder.append(typeName).append(".");
		builder.append(typeMethod.getName()).append("());");
		builder.append(newline);
		return builder.toString();
	}

}
