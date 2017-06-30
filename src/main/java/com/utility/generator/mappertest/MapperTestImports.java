package com.utility.generator.mappertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.utility.generator.clazz.part.GeneratedImports;


public class MapperTestImports implements GeneratedImports {

	private Class<?> originClass;

	public MapperTestImports(Class<?> originClass) {
		this.originClass = originClass;
	}

	@Override
	public List<Class<?>> classesToImport() {
		List<Class<?>> classesToImport = new ArrayList<>();

		classesToImport.add(originClass);
		classesToImport.add(List.class);
		classesToImport.add(ArrayList.class);
		classesToImport.add(Test.class);

		return classesToImport;
	}

}
