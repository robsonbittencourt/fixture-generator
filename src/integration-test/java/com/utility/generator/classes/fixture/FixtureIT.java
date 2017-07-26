package com.utility.generator.classes.fixture;

import static com.utility.generator.util.Utils.deleteFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.RandomFields;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.configuration.Configuration;

public class FixtureIT {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		configuration.setRootPath("src/integration-test/java/");

		generatedClass = new Fixture(RandomFields.class, configuration);
	}

	@After
	public void tearDown() {
		deleteFile("src/integration-test/java/com/utility/generator/randomstuff/RandomStuff.java");
		deleteFile("src/integration-test/java/com/utility/generator/base/clazz/RandomFieldsFixture.java");

		deleteFile("src/integration-test/java/com/utility/generator/randomstuff");
		deleteFile("src/integration-test/java/com/utility/generator/base/clazz");
		deleteFile("src/integration-test/java/com/utility/generator/base");
	}

	@Test
	public void classShouldHaveCorrectMethodQuantity() {
		assertEquals(34, generatedClass.methods().size());
	}

	@Test
	public void classShouldHaveCorrectMethods() {
		List<GeneratedMethod> methods = generatedClass.methods();

		assertTrue(methods.get(0) instanceof FixtureGetMethod);
		assertTrue(methods.get(1) instanceof FixtureBuildMethod);
		assertTrue(methods.get(2) instanceof FixtureBuildListMethod);
		assertTrue(methods.get(3) instanceof FixtureWithRandomValueMethod);
		assertTrue(methods.get(4) instanceof FixtureWithMethod);
		assertTrue(methods.get(5) instanceof FixtureWithRandomValueMethod);
		assertTrue(methods.get(6) instanceof FixtureWithMethod);
	}

	@Test
	public void shouldValidateTheGeneratedClass() throws IOException {
		StringBuilder builder = new StringBuilder();

		builder.append("package com.utility.generator.base.clazz;\n");
		builder.append("\n");

		builder.append("import java.util.List;\n");
		builder.append("import java.util.ArrayList;\n");
		builder.append("import com.utility.generator.base.clazz.RandomFields;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomString;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomInt;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomInteger;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomDouble;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomBigDecimal;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomBigInteger;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomBoolean;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomDate;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomLocalDate;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomFloat;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomLong;\n");
		builder.append("import java.math.BigDecimal;\n");
		builder.append("import java.math.BigInteger;\n");
		builder.append("import java.util.Date;\n");
		builder.append("import java.time.LocalDate;\n");

		builder.append("public class RandomFieldsFixture {\n");
		builder.append("\n");

		builder.append("	private RandomFields randomFields = new RandomFields();\n");
		builder.append("\n");

		builder.append("	public static RandomFieldsFixture get() {\n");
		builder.append("		return new RandomFieldsFixture();\n");
		builder.append("	}\n");
		builder.append("\n");

		builder.append("	public RandomFields build() {\n");
		builder.append("		return randomFields;\n");
		builder.append("	}\n");
		builder.append("\n");

		builder.append("	public List<RandomFields> buildList(Integer amount) {\n");
		builder.append("		List<RandomFields> randomFieldss = new ArrayList<>();\n");
		builder.append("		for (int i = 0; i < amount; i++) {\n");
		builder.append("			randomFieldss.add(this.build());\n");
		builder.append("		}\n");
		builder.append("		return randomFieldss;\n");
		builder.append("	}\n");
		builder.append("\n");

		builder.append("	public RandomFieldsFixture withStringField() {\n");
		builder.append("		this.randomFields.setStringField(getRandomString());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withStringField(String stringField) {\n");
		builder.append("		this.randomFields.setStringField(stringField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withIntField() {\n");
		builder.append("		this.randomFields.setIntField(getRandomInt());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withIntField(int intField) {\n");
		builder.append("		this.randomFields.setIntField(intField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withIntegerField() {\n");
		builder.append("		this.randomFields.setIntegerField(getRandomInteger());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withIntegerField(Integer integerField) {\n");
		builder.append("		this.randomFields.setIntegerField(integerField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDoubleField() {\n");
		builder.append("		this.randomFields.setDoubleField(getRandomDouble());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDoubleField(double doubleField) {\n");
		builder.append("		this.randomFields.setDoubleField(doubleField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDoubleObjectField() {\n");
		builder.append("		this.randomFields.setDoubleObjectField(getRandomDouble());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDoubleObjectField(Double doubleObjectField) {\n");
		builder.append("		this.randomFields.setDoubleObjectField(doubleObjectField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBigDecimalField() {\n");
		builder.append("		this.randomFields.setBigDecimalField(getRandomBigDecimal());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBigDecimalField(BigDecimal bigDecimalField) {\n");
		builder.append("		this.randomFields.setBigDecimalField(bigDecimalField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBigIntegerField() {\n");
		builder.append("		this.randomFields.setBigIntegerField(getRandomBigInteger());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBigIntegerField(BigInteger bigIntegerField) {\n");
		builder.append("		this.randomFields.setBigIntegerField(bigIntegerField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBooleanField() {\n");
		builder.append("		this.randomFields.setBooleanField(getRandomBoolean());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBooleanField(boolean booleanField) {\n");
		builder.append("		this.randomFields.setBooleanField(booleanField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBooleanObjectField() {\n");
		builder.append("		this.randomFields.setBooleanObjectField(getRandomBoolean());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withBooleanObjectField(Boolean booleanObjectField) {\n");
		builder.append("		this.randomFields.setBooleanObjectField(booleanObjectField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDateField() {\n");
		builder.append("		this.randomFields.setDateField(getRandomDate());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withDateField(Date dateField) {\n");
		builder.append("		this.randomFields.setDateField(dateField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withLocalDateField() {\n");
		builder.append("		this.randomFields.setLocalDateField(getRandomLocalDate());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withLocalDateField(LocalDate localDateField) {\n");
		builder.append("		this.randomFields.setLocalDateField(localDateField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withFloatField() {\n");
		builder.append("		this.randomFields.setFloatField(getRandomFloat());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withFloatField(float floatField) {\n");
		builder.append("		this.randomFields.setFloatField(floatField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withFloatObjectField() {\n");
		builder.append("		this.randomFields.setFloatObjectField(getRandomFloat());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withFloatObjectField(Float floatObjectField) {\n");
		builder.append("		this.randomFields.setFloatObjectField(floatObjectField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withLongField() {\n");
		builder.append("		this.randomFields.setLongField(getRandomLong());\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withLongField(long longField) {\n");
		builder.append("		this.randomFields.setLongField(longField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withLongObjectField() {\n");
		builder.append("		this.randomFields.setLongObjectField(getRandomLong());\n");
		finalizeMethod(builder);
		
		builder.append("	public RandomFieldsFixture withLongObjectField(Long longObjectField) {\n");
		builder.append("		this.randomFields.setLongObjectField(longObjectField);\n");
		finalizeMethod(builder);

		builder.append("	public RandomFieldsFixture withPropertyWithoutRandomValue(\n");
		builder.append("			Person propertyWithoutRandomValue) {\n");
		builder.append("		this.randomFields\n");
		builder.append("				.setPropertyWithoutRandomValue(propertyWithoutRandomValue);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("}");

		generatedClass.generate();

		String path = "src/integration-test/java/com/utility/generator/base/clazz/RandomFieldsFixture.java";
		String classContent = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

		assertEquals(builder.toString(), classContent);
	}

	private void finalizeMethod(StringBuilder builder) {
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
	}

}
