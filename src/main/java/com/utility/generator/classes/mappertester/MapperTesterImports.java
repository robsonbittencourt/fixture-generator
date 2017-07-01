package com.utility.generator.classes.mappertester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.utility.generator.clazz.part.GeneratedImports;


public class MapperTesterImports implements GeneratedImports {

	private Class<?> originClass;

	public MapperTesterImports(Class<?> originClass) {
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
