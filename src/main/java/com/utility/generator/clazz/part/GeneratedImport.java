package com.utility.generator.clazz.part;

public class GeneratedImport {

	private Class<?> clazz;
	private boolean staticImport = false;

	public GeneratedImport(Class<?> clazz) {
		this.clazz = clazz;
	}

	public GeneratedImport(Class<?> clazz, boolean staticImport) {
		this.clazz = clazz;
		this.staticImport = staticImport;
	}

	public String qualifiedName() {
		return clazz.getPackage().getName() + "." + clazz.getSimpleName();
	}

	public boolean isStatic() {
		return staticImport;
	}

}
