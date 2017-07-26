package com.utility.generator.clazz.part;

import java.util.Collections;
import java.util.List;

import com.utility.generator.file.FileBuilder;

public abstract class AbstractGeneratedClass implements GeneratedClass {

	@Override
	public List<GeneratedConstructor> constructors() {
		return Collections.emptyList();
	}

	public void generate() {
		String source = new JavaClassSourceWrapper(this).toString();

		new FileBuilder().createFile(name(), classFilePath(), source);
	}

}

