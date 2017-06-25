package com.utility.generator.clazz.part;

import java.util.List;

public interface GeneratedClass {
	
	GeneratedPackage packagge();
	
	GeneratedImports imports();

	String name();
	
	List<GeneratedField> fields();
	
	List<GeneratedConstructor> constructors();
	
	List<GeneratedMethod> methods();

	String classFilePath();

}
