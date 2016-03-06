package com.fixture.generator.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	public List<File> listJavaFiles(String directoryName) {
		List<File> files = new ArrayList<>();

		listJavaFiles(directoryName, files);

		return files;
	}

	private List<File> listJavaFiles(String directoryName, List<File> files) {
		File directory = new File(directoryName);

		File[] filesArray = directory.listFiles();
		for (File file : filesArray) {
			if (file.isFile() && isJavaFile(file)) {
				files.add(file);
			} else if (file.isDirectory()) {
				listJavaFiles(file.getAbsolutePath(), files);
			}
		}

		return files;
	}

	private static boolean isJavaFile(File file) {
		return file.getAbsolutePath().contains(".java");
	}

}
