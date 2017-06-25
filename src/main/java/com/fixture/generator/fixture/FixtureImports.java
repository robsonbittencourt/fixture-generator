package com.fixture.generator.fixture;

import java.util.ArrayList;
import java.util.List;

import com.fixture.generator.clazz.part.GeneratedImports;

public class FixtureImports implements GeneratedImports {
	
	private Class<?> originClass;
	
	protected FixtureImports(Class<?> originClass) {
		this.originClass = originClass;
	}

	@Override
	public List<Class<?>> classesToImport() {
		List<Class<?>> classesToImport = new ArrayList<>();
		
		classesToImport.add(List.class);
		classesToImport.add(ArrayList.class);
		classesToImport.add(originClass);
		
		return classesToImport;
	}
	
}
