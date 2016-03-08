package com.fixture.generator.util;

import java.lang.reflect.Field;

public class Utils {

	public static String upperFirstLetter(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}

	public static String lowerFirstLetter(String string) {
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}

	public static boolean hasSetMethod(Class<?> clazz, Field field) {
		try {
			clazz.getMethod("set" + Utils.upperFirstLetter(field.getName()), field.getType());
			return true;
		} catch (NoSuchMethodException | SecurityException e) {
			// do nothing
		}

		return false;
	}

}
