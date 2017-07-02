package com.utility.generator.randomstuff;

import java.util.Random;
import org.apache.commons.lang.math.RandomUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.Period;
public class RandomStuff {

	public static int getRandomInt() {
		return RandomUtils.nextInt();
	}

	public static Integer getRandomInteger() {
		return RandomUtils.nextInt();
	}

	public static double getRandomDouble() {
		return RandomUtils.nextDouble();
	}

	public static String getRandomString() {
		final Random random = new Random();
		final StringBuilder sb = new StringBuilder();
		int stringLength = 10;
		for (int i = 0; i < stringLength; i++) {
			switch (random.nextInt(3)) {
				case 0 :
					sb.append(new Character((char) (48 + random
							.nextInt((57 + 1 - 48)))));
					break;
				case 1 :
					sb.append(new Character((char) (97 + random
							.nextInt((122 + 1 - 97)))));
					break;
				case 2 :
					sb.append(new Character((char) (65 + random
							.nextInt((90 + 1 - 65)))));
					break;
				default :
					break;
			}
		}
		return sb.toString();
	}

	public static BigDecimal getRandomBigDecimal() {
		return BigDecimal.valueOf(RandomUtils.nextDouble());
	}

	public static BigInteger getRandomBigInteger() {
		return BigInteger.valueOf(RandomUtils.nextInt());
	}

	public static boolean getRandomBoolean() {
		return RandomUtils.nextBoolean();
	}

	public static Date getRandomDate() {
		LocalDate localDate = LocalDate.now().minus(
				Period.ofDays((new Random().nextInt(365 * 70))));
		return new Date(localDate.atStartOfDay(ZoneId.of("America/New_York"))
				.toEpochSecond() * 1000);
	}

	public static LocalDate getRandomLocalDate() {
		return LocalDate.now().minus(
				Period.ofDays((new Random().nextInt(365 * 70))));
	}

	public static float getRandomFloat() {
		return RandomUtils.nextFloat();
	}

	public static long getRandomLong() {
		return RandomUtils.nextLong();
	}
}