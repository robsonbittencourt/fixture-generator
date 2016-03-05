package com.fixture.generator.util;

public class Utils {

	public static String upperFirstLetter(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}

	public static String lowerFirstLetter(String string) {
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}

}
