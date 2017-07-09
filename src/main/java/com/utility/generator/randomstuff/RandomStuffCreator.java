package com.utility.generator.randomstuff;

import static com.utility.generator.util.Utils.upperFirstLetter;
import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.utility.generator.clazz.part.GeneratedImport;

public class RandomStuffCreator {

	public GeneratedImport buildImport(Class<?> clazz, boolean isStatic) {
		if (isTypeWithRandomValueAvailable(clazz)) {
			String qualifiedName = buildQualifiedName(clazz);
			return new GeneratedImport(qualifiedName, isStatic);
		}

		return null;
	}

	private String buildQualifiedName(Class<?> clazz) {
		String qualifiedPrefix = "com.utility.generator.randomstuff.RandomStuff.getRandom";
		String type = upperFirstLetter(clazz.getSimpleName());

		return qualifiedPrefix + type;
	}

	private boolean isTypeWithRandomValueAvailable(Class<?> type) {
		for (Class<?> availableType : availableTypes()) {
			if (type.equals(availableType)) {
				return true;
			}
		}

		return false;
	}

	private List<Class<?>> availableTypes() {
		return asList(Integer.TYPE, Integer.class, Double.TYPE, Double.class, Boolean.TYPE, Boolean.class, String.class,
				BigDecimal.class, BigInteger.class, Date.class, LocalDate.class, Float.TYPE, Float.class, Long.TYPE,
				Long.class);
	}

}
