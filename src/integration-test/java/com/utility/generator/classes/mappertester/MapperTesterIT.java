package com.utility.generator.classes.mappertester;

import static com.utility.generator.util.Utils.deleteFile;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.ServicePerson;
import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.configuration.Configuration;

public class MapperTesterIT {

	private AbstractGeneratedClass generatedClass;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		configuration.setClassNameSuffix("Test");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");
		configuration.setRootPath("src/integration-test/java/");

		generatedClass = new MapperTester(SimpleMapper.class, configuration);
	}

	@After
	public void tearDown() {
		deleteFile("src/integration-test/java/com/utility/generator/randomstuff/RandomStuff.java");
		deleteFile("src/integration-test/java/com/utility/generator/base/clazz/SimpleMapperTest.java");

		deleteFile("src/integration-test/java/com/utility/generator/randomstuff");
		deleteFile("src/integration-test/java/com/utility/generator/base/clazz");
		deleteFile("src/integration-test/java/com/utility/generator/base");
	}

	@Test
	public void shouldValidateTheGeneratedClass() throws IOException {
		StringBuilder builder = new StringBuilder();

		builder.append("package com.utility.generator.base.clazz;\n");
		builder.append("\n");
		builder.append("import com.utility.generator.base.clazz.SimpleMapper;\n");
		builder.append("import org.junit.Test;\n");
		builder.append("import static org.junit.Assert.assertEquals;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomInt;\n");
		builder.append("import static com.utility.generator.randomstuff.RandomStuff.getRandomString;\n");
		builder.append("public class SimpleMapperTest {\n");
		builder.append("\n");
		builder.append("	@Test\n");
		builder.append("	public void shouldTestAllParams() {\n");
		builder.append("		Person entity = new Person();\n");
		builder.append("		entity.setAge(getRandomInt());\n");
		builder.append("		entity.setRandomFields(getRandomRandomFields());\n");
		builder.append("		entity.setName(getRandomString());\n");
		builder.append("		ServicePerson type = new SimpleMapper().toType(entity);\n");
		builder.append("		assertEquals(entity.getAge(), type.getAge());\n");
		builder.append("		assertEquals(entity.getRandomFields(), type.getRandomFields());\n");
		builder.append("		assertEquals(entity.getName(), type.getName());\n");
		builder.append("	}\n");
		builder.append("}");

		generatedClass.generate();

		String path = "src/integration-test/java/com/utility/generator/base/clazz/SimpleMapperTest.java";
		String classContent = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

		assertEquals(builder.toString(), classContent);
	}

}
