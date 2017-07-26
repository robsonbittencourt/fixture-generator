package com.utility.generator.classes.randomstuff;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.utility.generator.clazz.part.GeneratedPackage;

public class RandomStuffPackageTest {

	private GeneratedPackage packagge;

	@Before
	public void setUp() {
		packagge = new RandomStuffPackage();
	}

	@Test
	public void shouldReturnConfiguredPackage() {
		String name = packagge.name();

		assertEquals("com.utility.generator.randomstuff", name);
	}

}
