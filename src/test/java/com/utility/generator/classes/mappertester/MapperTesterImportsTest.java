package com.utility.generator.classes.mappertester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.classes.mappertester.MapperTesterImports;
import com.utility.generator.clazz.part.GeneratedImports;

public class MapperTesterImportsTest {

	private GeneratedImports method;

	@Before
	public void setUp() {
		method = new MapperTesterImports(SimpleMapper.class);
	}

	@Test
	public void shouldImportThreeClasses() {
		assertEquals(4, method.classesToImport().size());
	}

	@Test
	public void shouldImportNecessaryClasses() {
		List<Class<?>> classesToImport = method.classesToImport();

		assertEquals(SimpleMapper.class, classesToImport.get(0));
		assertEquals(List.class, classesToImport.get(1));
		assertEquals(ArrayList.class, classesToImport.get(2));
		assertEquals(Test.class, classesToImport.get(3));
	}

}
