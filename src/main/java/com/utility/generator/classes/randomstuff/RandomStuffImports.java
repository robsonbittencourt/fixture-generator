package com.utility.generator.classes.randomstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

import com.utility.generator.clazz.part.GeneratedImports;

public class RandomStuffImports implements GeneratedImports {

	@Override
	public List<Class<?>> classesToImport() {
		List<Class<?>> classesToImport = new ArrayList<>();

		classesToImport.add(Random.class);
		classesToImport.add(RandomUtils.class);

		return classesToImport;
	}

}
