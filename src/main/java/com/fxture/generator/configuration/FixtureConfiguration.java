package com.fxture.generator.configuration;

import org.apache.commons.lang3.StringUtils;

public class FixtureConfiguration {

	private static final String DEFAULT_METHOD_PREFIX = "with";
	private String methodPrefix;

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
