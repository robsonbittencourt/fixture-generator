package com.utility.generator.clazz.part;

import java.util.List;

public interface GeneratedClass {
	
	GeneratedPackage packagge();
	
	List<GeneratedImport> imports();

	String name();
	
	List<GeneratedField> fields();
	
	List<GeneratedConstructor> constructors();
	
	List<GeneratedMethod> methods();

	String classFilePath();

}
