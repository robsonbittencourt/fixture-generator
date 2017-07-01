package com.utility.generator.classes.fixture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
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
		generatedClass = new Fixture(Person.class, new Configuration());
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
		assertEquals("com.utility.generator.base.clazz.Person", generatedImports.get(2).qualifiedName());
	}

	@Test
	public void classNameShouldBeTheNameOfOriginClassWithConfiguredSuffix() {
		assertEquals("PersonFixture", generatedClass.name());
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
	public void classShouldHaveFiveMethods() {
		assertEquals(5, generatedClass.methods().size());
	}

	@Test
	public void classShouldHaveCorrectMethods() {
		List<GeneratedMethod> methods = generatedClass.methods();

		assertTrue(methods.get(0) instanceof FixtureGetMethod);
		assertTrue(methods.get(1) instanceof FixtureBuildMethod);
		assertTrue(methods.get(2) instanceof FixtureBuildListMethod);
		assertTrue(methods.get(3) instanceof FixtureWithMethod);
		assertTrue(methods.get(4) instanceof FixtureWithMethod);
	}

	@Test
	public void shouldReturnThePathWithOriginClassPackageNameWhenDoNotHavePackageNameInConfiguration() {
		assertEquals("src/test/java/com/utility/generator/base/clazz", generatedClass.classFilePath());
	}

	@Test
	public void shouldReturnThePathWithConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setPackageName("com.generator");

		generatedClass = new Fixture(Person.class, configuration);

		assertEquals("src/test/java/com/generator", generatedClass.classFilePath());
	}

	@Test
	public void shouldValidateTheGeneratedClass() {
		StringBuilder builder = new StringBuilder();

		builder.append("package com.utility.generator.base.clazz;\n");
		builder.append("\n");
		builder.append("import java.util.List;\n");
		builder.append("import java.util.ArrayList;\n");
		builder.append("import com.utility.generator.base.clazz.Person;\n");
		builder.append("public class PersonFixture {\n");
		builder.append("\n");
		builder.append("	public Person person = new Person();\n");
		builder.append("\n");
		builder.append("	public static PersonFixture get() {\n");
		builder.append("		return new PersonFixture();\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public Person build() {\n");
		builder.append("		return person;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public List<Person> buildList(Integer amount) {\n");
		builder.append("		List<Person> persons = new ArrayList<>();\n");
		builder.append("		for (int i = 0; i < amount; i++) {\n");
		builder.append("			persons.add(this.build());\n");
		builder.append("		}\n");
		builder.append("		return persons;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public PersonFixture withName(String name) {\n");
		builder.append("		this.person.setName(name);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("\n");
		builder.append("	public PersonFixture withAge(int age) {\n");
		builder.append("		this.person.setAge(age);\n");
		builder.append("		return this;\n");
		builder.append("	}\n");
		builder.append("}");

		assertEquals(builder.toString(), generatedClass.toString());
	}

}
