package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.getPathFromPackageName;
import static com.utility.generator.util.Utils.hasSetMethod;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImports;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class Fixture extends AbstractGeneratedClass {

	private Class<?> originClass;
	private Configuration configuration;
	
	public Fixture(Class<?> originClass, Configuration configuration) {
		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public GeneratedPackage packagge() {
		return new FixturePackage(originClass, configuration);
	}

	@Override
	public GeneratedImports imports() {
		return new FixtureImports(originClass);
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
		List<GeneratedMethod> methods = new ArrayList<>();
		
		methods.add(new FixtureGetMethod(originClass));
		methods.add(new FixtureBuildMethod(originClass));
		methods.add(new FixtureBuildListMethod(originClass));
		
		for (Field field : originClass.getDeclaredFields()) {
			if (!hasSetMethod(originClass, field)) {
				continue;
			}
			
			methods.add(new FixtureWithMethod(originClass, configuration, field));
		}
		
		return methods;
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
