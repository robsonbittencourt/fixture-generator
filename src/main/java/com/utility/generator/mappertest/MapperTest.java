package com.utility.generator.mappertest;

import static com.utility.generator.util.Utils.getPathFromPackageName;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImports;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.FixtureConfiguration;

public class MapperTest extends AbstractGeneratedClass {

	private Class<?> originClass;
	private FixtureConfiguration configuration;

	public MapperTest(Class<?> originClass, FixtureConfiguration configuration) {
		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public GeneratedPackage packagge() {
		return new MapperTestPackage(originClass, configuration);
	}

	@Override
	public GeneratedImports imports() {
		return new MapperTestImports(originClass);
	}

	@Override
	public String name() {
		return originClass.getSimpleName() + configuration.getClassNameSuffix();
	}

	@Override
	public List<GeneratedField> fields() {
		return Collections.emptyList();
	}

	@Override
	public List<GeneratedMethod> methods() {
		List<GeneratedMethod> methods = new ArrayList<>();

		methods.add(new MapperTestShouldTestAllParamsMethod(configuration));

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
