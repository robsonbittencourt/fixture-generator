package com.utility.generator.randomstuff;

import java.util.Random;
import org.apache.commons.lang.math.RandomUtils;
public class RandomStuff {

	public static int getRandomInt() {
		return RandomUtils.nextInt();
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
}