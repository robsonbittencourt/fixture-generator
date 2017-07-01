package com.utility.generator.classes.mappertester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.ServicePerson;
import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class MapperTesterTest {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);
	}
	
	@Test
	public void shouldReturnMapperTesterPackageAsPackage() {
		GeneratedPackage generatedPackage = generatedClass.packagge();

		assertTrue(generatedPackage instanceof MapperTesterPackage);
	}

	@Test
	public void shouldReturnTheCorrectImports() {
		List<GeneratedImport> generatedImports = generatedClass.imports();

		assertEquals(4, generatedImports.size());
		assertEquals("com.utility.generator.base.clazz.SimpleMapper", generatedImports.get(0).qualifiedName());
		assertEquals("java.util.List", generatedImports.get(1).qualifiedName());
		assertEquals("java.util.ArrayList", generatedImports.get(2).qualifiedName());
		assertEquals("org.junit.Test", generatedImports.get(3).qualifiedName());
	}

	@Test
	public void classNameShouldBeTheNameOfOriginClassWithConfiguredSuffix() {
		assertEquals("SimpleMapperTest", generatedClass.name());
	}

	@Test
	public void shouldNotHaveAnyFields() {
		List<GeneratedField> fields = generatedClass.fields();
		
		assertTrue(fields.isEmpty());
	}
	
	@Test
	public void shouldNotHaveAnyConstructors() {
		assertTrue(generatedClass.constructors().isEmpty());
	}

	@Test
	public void classShouldHaveOneMethod() {
		assertEquals(1, generatedClass.methods().size());
	}

	@Test
	public void classShouldHaveCorrectMethods() {
		List<GeneratedMethod> methods = generatedClass.methods();

		assertTrue(methods.get(0) instanceof MapperTesterShouldTestAllParamsMethod);
	}

	@Test
	public void shouldReturnThePathWithOriginClassPackageNameWhenDoNotHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);

		assertEquals("src/test/java/com/utility/generator/base/clazz", generatedClass.classFilePath());
	}

	@Test
	public void shouldReturnThePathWithConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");
		configuration.setPackageName("com.generator");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);

		assertEquals("src/test/java/com/generator", generatedClass.classFilePath());
	}

	@Test
	public void shouldValidateTheGeneratedClass() {
		StringBuilder builder = new StringBuilder();

		builder.append("package com.utility.generator.base.clazz;\n");
		builder.append("\n");
		builder.append("import com.utility.generator.base.clazz.SimpleMapper;\n");
		builder.append("import java.util.List;\n");
		builder.append("import java.util.ArrayList;\n");
		builder.append("import org.junit.Test;\n");
		builder.append("public class SimpleMapperTest {\n");
		builder.append("\n");
		builder.append("	@Test\n");
		builder.append("	public void shouldTestAllParams() {\n");
		builder.append("		Person entity = new Person();\n");
		builder.append("		entity.setAge(getRandomint());\n");
		builder.append("		entity.setName(getRandomString());\n");
		builder.append("		ServicePerson type = mapper.toType(entity);\n");
		builder.append("		assertEquals(entity.getAge(), type.getAge());\n");
		builder.append("		assertEquals(entity.getName(), type.getName());\n");
		builder.append("	}\n");
		builder.append("}");

		assertEquals(builder.toString(), generatedClass.toString());
	}

}
