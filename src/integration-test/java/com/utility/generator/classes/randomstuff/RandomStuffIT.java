package com.utility.generator.classes.randomstuff;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.configuration.Configuration;

public class RandomStuffIT {

	private static final String SWITCH_BREAK = "					break;\n";
	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		configuration.setRootPath("src/integration-test/java/");

		generatedClass = new RandomStuff(configuration);
	}

	@Test
	public void shouldValidateTheGeneratedClass() throws IOException {
		StringBuilder builder = new StringBuilder();
		
		builder.append("package com.utility.generator.randomstuff;\n");
		builder.append("\n");
		
		builder.append("import java.util.Random;\n");
		builder.append("import org.apache.commons.lang.math.RandomUtils;\n");
		builder.append("import java.math.BigDecimal;\n");
		builder.append("import java.math.BigInteger;\n");
		builder.append("import java.util.Date;\n");
		builder.append("import java.time.ZoneId;\n");
		builder.append("import java.time.LocalDate;\n");
		builder.append("import java.time.Period;\n");
		
		builder.append("public class RandomStuff {\n");
		builder.append("\n");

		builder.append("	public static int getRandomInt() {\n");
		builder.append("		return RandomUtils.nextInt();\n");
		finalizeMethod(builder);

		builder.append("	public static Integer getRandomInteger() {\n");
		builder.append("		return RandomUtils.nextInt();\n");
		finalizeMethod(builder);

		builder.append("	public static double getRandomDouble() {\n");
		builder.append("		return RandomUtils.nextDouble();\n");
		finalizeMethod(builder);

		builder.append("	public static String getRandomString() {\n");
		builder.append("		final Random random = new Random();\n");
		builder.append("		final StringBuilder sb = new StringBuilder();\n");
		builder.append("		int stringLength = 10;\n");
		builder.append("		for (int i = 0; i < stringLength; i++) {\n");
		builder.append("			switch (random.nextInt(3)) {\n");
		builder.append("				case 0 :\n");
		builder.append("					sb.append(new Character((char) (48 + random\n");
		builder.append("							.nextInt((57 + 1 - 48)))));\n");
		builder.append(SWITCH_BREAK);
		builder.append("				case 1 :\n");
		builder.append("					sb.append(new Character((char) (97 + random\n");
		builder.append("							.nextInt((122 + 1 - 97)))));\n");
		builder.append(SWITCH_BREAK);
		builder.append("				case 2 :\n");
		builder.append("					sb.append(new Character((char) (65 + random\n");
		builder.append("							.nextInt((90 + 1 - 65)))));\n");
		builder.append(SWITCH_BREAK);
		builder.append("				default :\n");
		builder.append(SWITCH_BREAK);
		builder.append("			}\n");
		builder.append("		}\n");
		builder.append("		return sb.toString();\n");
		finalizeMethod(builder);

		builder.append("	public static BigDecimal getRandomBigDecimal() {\n");
		builder.append("		return BigDecimal.valueOf(RandomUtils.nextDouble());\n");
		finalizeMethod(builder);

		builder.append("	public static BigInteger getRandomBigInteger() {\n");
		builder.append("		return BigInteger.valueOf(RandomUtils.nextInt());\n");
		finalizeMethod(builder);

		builder.append("	public static boolean getRandomBoolean() {\n");
		builder.append("		return RandomUtils.nextBoolean();\n");
		finalizeMethod(builder);

		builder.append("	public static Date getRandomDate() {\n");
		builder.append("		LocalDate localDate = LocalDate.now().minus(\n");
		builder.append("				Period.ofDays((new Random().nextInt(365 * 70))));\n");
		builder.append("		return new Date(localDate.atStartOfDay(ZoneId.of(\"America/New_York\"))\n");
		builder.append("				.toEpochSecond() * 1000);\n");
		finalizeMethod(builder);

		builder.append("	public static LocalDate getRandomLocalDate() {\n");
		builder.append("		return LocalDate.now().minus(\n");
		builder.append("				Period.ofDays((new Random().nextInt(365 * 70))));\n");
		finalizeMethod(builder);

		builder.append("	public static float getRandomFloat() {\n");
		builder.append("		return RandomUtils.nextFloat();\n");
		finalizeMethod(builder);

		builder.append("	public static long getRandomLong() {\n");
		builder.append("		return RandomUtils.nextLong();\n");
		builder.append("	}\n");
		builder.append("}");

		generatedClass.generate();

		String path = "src/integration-test/java/com/utility/generator/randomstuff/RandomStuff.java";
		String classContent = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

		assertEquals(builder.toString(), classContent);
	}

	private void finalizeMethod(StringBuilder builder) {
		builder.append("	}\n");
		builder.append("\n");
	}

}
