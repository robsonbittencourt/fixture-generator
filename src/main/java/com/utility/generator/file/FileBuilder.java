package com.utility.generator.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.utility.generator.exception.FixtureGeneratorException;

public class FileBuilder {

	public void createFile(String className, String path, String content) {
		try {
			File file = new File(path + "/" + className + ".java");
			file.getParentFile().mkdirs();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			throw new FixtureGeneratorException("An error occurred while generating the file: " + e.getMessage());
		}
	}

}
