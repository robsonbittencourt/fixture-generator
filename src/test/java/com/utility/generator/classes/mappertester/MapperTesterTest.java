package com.utility.generator.classes.mappertester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.RandomFields;
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

		assertEquals(3, generatedImports.size());
		assertEquals("com.utility.generator.base.clazz.SimpleMapper", generatedImports.get(0).qualifiedName());
		assertEquals("org.junit.Test", generatedImports.get(1).qualifiedName());
		assertEquals("org.junit.Assert.assertEquals", generatedImports.get(2).qualifiedName());
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
		configuration.setEntityClass(RandomFields.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);

		assertEquals("src/test/java/com/utility/generator/base/clazz", generatedClass.classFilePath());
	}

	@Test
	public void shouldReturnThePathWithConfiguredPackageNameWhenHavePackageNameInConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(RandomFields.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");
		configuration.setPackageName("com.generator");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);

		assertEquals("src/test/java/com/generator", generatedClass.classFilePath());
	}

}
