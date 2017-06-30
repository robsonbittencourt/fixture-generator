package com.utility.generator.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.ServicePerson;
import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.configuration.FixtureConfiguration;

public class ClassGeneratorTest {

	@Test
	public void shouldValidateTheGeneratedClass() {
		StringBuilder builder = new StringBuilder();

		builder.append("package com.utility.generator.base.clazz;\n");
		builder.append("\n");
		builder.append("import com.utility.generator.base.clazz.SimpleMapper;\n");
		builder.append("import java.util.List;\n");
		builder.append("import java.util.ArrayList;\n");
		builder.append("import org.junit.Test;\n");
		builder.append("public class SimpleMapperMapper {\n");
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
		
		FixtureConfiguration configuration = new FixtureConfiguration();
		configuration.setClassNameSuffix("Mapper");
		configuration.setEntityClass(Person.class);
		configuration.setTypeClass(ServicePerson.class);
		configuration.setMethodName("shouldTestAllParams");

		ClassGenerator classGenerator = new ClassGenerator(configuration);

		String classGenrated = classGenerator.toString(SimpleMapper.class);

		assertEquals(builder.toString(), classGenrated);
	}

}
