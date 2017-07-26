package com.utility.generator.util;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

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

	public static String getPathFromPackageName(String packageName) {
		return packageName.replace(".", "/");
	}

	public static List<Method> extractSetters(Class<?> clazz) {
		return stream(clazz.getDeclaredMethods()).filter(method -> method.getName().startsWith("set"))
				.collect(toList());
	}

	public static void deleteFile(String path) {
		File file = new File(path);
		if (!file.delete()) {
			// file delete failed; take appropriate action
		}
	}

}
