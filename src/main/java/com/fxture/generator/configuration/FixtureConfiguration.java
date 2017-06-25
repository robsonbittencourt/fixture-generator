package com.fxture.generator.configuration;

import org.apache.commons.lang3.StringUtils;

public class FixtureConfiguration {

	private static final String DEFAULT_METHOD_PREFIX = "with";
	private static final String DEFAULT_ROOT_PATH = "src/test/java/";

	private String rootPath;
	private String packageName;
	private String methodPrefix;
	private String classNameSuffix;
	private String methodName;
	private Class<?> typeClass;
	private Class<?> entityClass;

	public String getRootPath() {
		if (StringUtils.isNotBlank(rootPath)) {
			return rootPath;
		}

		return DEFAULT_ROOT_PATH;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getMethodPrefix() {
		if (StringUtils.isNotBlank(methodPrefix)) {
			return methodPrefix;
		}

		return DEFAULT_METHOD_PREFIX;
	}

	public void setMethodPrefix(String methodPrefix) {
		this.methodPrefix = methodPrefix;
	}

	public String getClassNameSuffix() {
		if (StringUtils.isBlank(classNameSuffix)) {
			return "Fixture";
		}
		
		return classNameSuffix;
	}

	public void setClassNameSuffix(String classNameSuffix) {
		this.classNameSuffix = classNameSuffix;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class<?> getTypeClass() {
		return typeClass;
	}

	public void setTypeClass(Class<?> typeClass) {
		this.typeClass = typeClass;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	
}
