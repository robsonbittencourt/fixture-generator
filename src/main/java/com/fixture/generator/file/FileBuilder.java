package com.fixture.generator.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileBuilder {

	public void createFile(String className, String packagePath, String content) {
		try {
			File file = new File("src/main/java/" + packagePath + "/" + className + ".java");
			file.getParentFile().mkdirs();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// TODO
		}
	}

}
