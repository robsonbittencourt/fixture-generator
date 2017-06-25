package com.utility.generator.clazz.part;

import java.util.Collections;
import java.util.List;

import com.utility.generator.file.FileBuilder;

public abstract class AbstractGeneratedClass implements GeneratedClass {

	@Override
	public List<GeneratedConstructor> constructors() {
		return Collections.emptyList();
	}

	@Override
	public String toString() {
		return new JavaClassSourceWrapper(this).toString();
	}

	public void generate() {
		String source = new JavaClassSourceWrapper(this).toString();

		new FileBuilder().createFile(name(), classFilePath(), source);
	}

}

