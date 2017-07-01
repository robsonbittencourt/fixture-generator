package com.utility.generator.classes.randomstuff;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import com.utility.generator.clazz.part.GeneratedImports;

public class RandomStuffImportsTest {

	private GeneratedImports method;

	@Before
	public void setUp() {
		method = new RandomStuffImports();
	}

	@Test
	public void shouldImportTwoClasses() {
		assertEquals(2, method.classesToImport().size());
	}

	@Test
	public void shouldImportNecessaryClasses() {
		List<Class<?>> classesToImport = method.classesToImport();

		assertEquals(Random.class, classesToImport.get(0));
		assertEquals(RandomUtils.class, classesToImport.get(1));
	}

}
