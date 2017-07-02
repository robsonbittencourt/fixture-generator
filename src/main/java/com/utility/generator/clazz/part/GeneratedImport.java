package com.utility.generator.clazz.part;

public class GeneratedImport {

	private String qualifiedName;
	private boolean staticImport = false;

	public GeneratedImport(Class<?> clazz) {
		this.qualifiedName = clazz.getPackage().getName() + "." + clazz.getSimpleName();
	}

	public GeneratedImport(Class<?> clazz, boolean staticImport) {
		this.qualifiedName = clazz.getPackage().getName() + "." + clazz.getSimpleName();
		this.staticImport = staticImport;
	}

	public GeneratedImport(String qualifiedName, boolean staticImport) {
		this.qualifiedName = qualifiedName;
		this.staticImport = staticImport;
	}

	public String qualifiedName() {
		return qualifiedName;
	}

	public boolean isStatic() {
		return staticImport;
	}

}
