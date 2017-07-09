package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.getPathFromPackageName;
import static com.utility.generator.util.Utils.hasSetMethod;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.utility.generator.classes.randomstuff.RandomStuff;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;
import com.utility.generator.validator.FixtureCandidateValidator;

public class Fixture extends AbstractGeneratedClass {

	private Class<?> originClass;
	private Configuration configuration;

	public Fixture(Class<?> originClass, Configuration configuration) {
		new FixtureCandidateValidator().validate(originClass);

		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public GeneratedPackage packagge() {
		return new FixturePackage(originClass, configuration);
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();

		imports.add(new GeneratedImport(List.class));
		imports.add(new GeneratedImport(ArrayList.class));
		imports.add(new GeneratedImport(originClass));

		return imports;
	}

	@Override
	public String name() {
		return originClass.getSimpleName() + configuration.getClassNameSuffix();
	}

	@Override
	public List<GeneratedField> fields() {
		List<GeneratedField> fields = new ArrayList<>();

		fields.add(new FixtureBaseField(originClass));

		return fields;
	}

	@Override
	public List<GeneratedMethod> methods() {
		createRandomStuffIfNecessary();

		List<GeneratedMethod> methods = new ArrayList<>();

		methods.add(new FixtureGetMethod(originClass));
		methods.add(new FixtureBuildMethod(originClass));
		methods.add(new FixtureBuildListMethod(originClass));

		for (Field field : originClass.getDeclaredFields()) {
			addWithMethods(methods, field);
		}

		return methods;
	}

	private void createRandomStuffIfNecessary() {
		try {
			Class.forName("com.utility.generator.randomstuff.RandomStuff");
		} catch (ClassNotFoundException e) {
			new RandomStuff(configuration).generate();
		}
	}

	private void addWithMethods(List<GeneratedMethod> methods, Field field) {
		if (!hasSetMethod(originClass, field)) {
			return;
		}

		if (isTypeWithRandomValueAvailable(field.getType())) {
			methods.add(new FixtureWithRandomValueMethod(originClass, configuration, field));
		}

		methods.add(new FixtureWithMethod(originClass, configuration, field));
	}

	private boolean isTypeWithRandomValueAvailable(Class<?> type) {
		for (Class<?> availableType : availableTypes()) {
			if (type.equals(availableType)) {
				return true;
			}
		}

		return false;
	}

	private List<Class<?>> availableTypes() {
		return asList(Integer.TYPE, Integer.class, Double.TYPE, Double.class, Boolean.TYPE, Boolean.class, String.class,
				BigDecimal.class, BigInteger.class, Date.class, LocalDate.class, Float.TYPE, Float.class, Long.TYPE,
				Long.class);
	}

	@Override
	public String classFilePath() {
		String path = configuration.getRootPath();

		if (isBlank(configuration.getPackageName())) {
			path += getPathFromPackageName(originClass.getPackage().getName());
		} else {
			path += getPathFromPackageName(configuration.getPackageName());
		}

		return path;
	}

}
