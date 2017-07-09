package com.utility.generator.base.clazz;

import com.utility.generator.base.clazz.SimpleMapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.utility.generator.randomstuff.RandomStuff.getRandomInt;
import static com.utility.generator.randomstuff.RandomStuff.getRandomString;
public class SimpleMapperTest {

	@Test
	public void shouldTestAllParams() {
		Person entity = new Person();
		entity.setAge(getRandomInt());
		entity.setName(getRandomString());
		ServicePerson type = new SimpleMapper().toType(entity);
		assertEquals(entity.getAge(), type.getAge());
		assertEquals(entity.getName(), type.getName());
	}
}