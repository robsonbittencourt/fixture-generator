package com.fxture.generator.configuration;

import org.apache.commons.lang3.StringUtils;

public class FixtureConfiguration {

	private static final String DEFAULT_METHOD_PREFIX = "with";
	private static final String DEFAULT_ROOT_PATH = "src/test/java/";

	private String rootPath;
	private String packageName;
	private String methodPrefix;

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

}
