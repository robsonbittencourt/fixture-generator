package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.RandomFields;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class FixtureTest {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		generatedClass = new Fixture(RandomFields.class, new Configuration());
	}

	@Test
	public void shouldReturnFixturePackageAsPackage() {
		GeneratedPackage generatedPackage = generatedClass.packagge();

		assertTrue(generatedPackage instanceof FixturePackage);
	}

	@Test
	public void shouldReturnTheCorrectImports() {
		List<GeneratedImport> generatedImports = generatedClass.imports();

		assertEquals(3, generatedImports.size());
		assertEquals("java.util.List", generatedImports.get(0).qualifiedName());
		assertEquals("java.util.ArrayList", generatedImports.get(1).qualifiedName());
		assertEquals("com.utility.generator.base.clazz.RandomFields", generatedImports.get(2).qualifiedName());
	}

	@Test
	public void classNameShouldBeTheNameOfOriginClassWithConfiguredSuffix() {
		assertEquals("RandomFieldsFixture", generatedClass.name());
	}

	@Test
	public void classShouldHaveOneField() {
		assertEquals(1, generatedClass.fields().size());
	}

	@Test
	public void shouldReturnAListWithFixtureBaseField() {
		GeneratedField generatedField = generatedClass.fields().get(0);

		assertTrue(generatedField instanceof FixtureBaseField);
	}

	@Test
	public void shouldNotHaveAnyConstructors() {
		assertTrue(generatedClass.constructors().isEmpty());
	}

	@Test
	public void classShouldHaveCorrectMethodQuantity() {
		assertEquals(33, generatedClass.methods().size());
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
	public void shouldReturnThePathWithOriginClassPackageNameWhenDoNotHavePackageNameInConfiguration() {
		assertEquals("src/test/java/com/utility/generator/base/clazz", generatedClass.classFilePath());
	}

	@Test
	public void shouldReturnThePathWithConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setPackageName("com.generator");

		generatedClass = new Fixture(RandomFields.class, configuration);

		assertEquals("src/test/java/com/generator", generatedClass.classFilePath());
	}

	@Test
	public void shouldValidateTheGeneratedClass() {
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
		builder.append("	public RandomFields randomFields = new RandomFields();\n");
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
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withStringField(String stringField) {\n");
		builder.append("		this.randomFields.setStringField(stringField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withIntField() {\n");
		builder.append("		this.randomFields.setIntField(getRandomInt());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withIntField(int intField) {\n");
		builder.append("		this.randomFields.setIntField(intField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withIntegerField() {\n");
		builder.append("		this.randomFields.setIntegerField(getRandomInteger());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withIntegerField(Integer integerField) {\n");
		builder.append("		this.randomFields.setIntegerField(integerField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDoubleField() {\n");
		builder.append("		this.randomFields.setDoubleField(getRandomDouble());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDoubleField(double doubleField) {\n");
		builder.append("		this.randomFields.setDoubleField(doubleField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDoubleObjectField() {\n");
		builder.append("		this.randomFields.setDoubleObjectField(getRandomDouble());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDoubleObjectField(Double doubleObjectField) {\n");
		builder.append("		this.randomFields.setDoubleObjectField(doubleObjectField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBigDecimalField() {\n");
		builder.append("		this.randomFields.setBigDecimalField(getRandomBigDecimal());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBigDecimalField(BigDecimal bigDecimalField) {\n");
		builder.append("		this.randomFields.setBigDecimalField(bigDecimalField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBigIntegerField() {\n");
		builder.append("		this.randomFields.setBigIntegerField(getRandomBigInteger());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBigIntegerField(BigInteger bigIntegerField) {\n");
		builder.append("		this.randomFields.setBigIntegerField(bigIntegerField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBooleanField() {\n");
		builder.append("		this.randomFields.setBooleanField(getRandomBoolean());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBooleanField(boolean booleanField) {\n");
		builder.append("		this.randomFields.setBooleanField(booleanField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBooleanObjectField() {\n");
		builder.append("		this.randomFields.setBooleanObjectField(getRandomBoolean());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withBooleanObjectField(Boolean booleanObjectField) {\n");
		builder.append("		this.randomFields.setBooleanObjectField(booleanObjectField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDateField() {\n");
		builder.append("		this.randomFields.setDateField(getRandomDate());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withDateField(Date dateField) {\n");
		builder.append("		this.randomFields.setDateField(dateField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLocalDateField() {\n");
		builder.append("		this.randomFields.setLocalDateField(getRandomLocalDate());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLocalDateField(LocalDate localDateField) {\n");
		builder.append("		this.randomFields.setLocalDateField(localDateField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withFloatField() {\n");
		builder.append("		this.randomFields.setFloatField(getRandomFloat());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withFloatField(float floatField) {\n");
		builder.append("		this.randomFields.setFloatField(floatField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withFloatObjectField() {\n");
		builder.append("		this.randomFields.setFloatObjectField(getRandomFloat());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withFloatObjectField(Float floatObjectField) {\n");
		builder.append("		this.randomFields.setFloatObjectField(floatObjectField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLongField() {\n");
		builder.append("		this.randomFields.setLongField(getRandomLong());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLongField(long longField) {\n");
		builder.append("		this.randomFields.setLongField(longField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLongObjectField() {\n");
		builder.append("		this.randomFields.setLongObjectField(getRandomLong());\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public RandomFieldsFixture withLongObjectField(Long longObjectField) {\n");
		builder.append("		this.randomFields.setLongObjectField(longObjectField);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("}");

		assertEquals(builder.toString(), generatedClass.toString());
	}

}
