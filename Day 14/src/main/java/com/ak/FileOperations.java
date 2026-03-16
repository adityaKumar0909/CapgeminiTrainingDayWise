package com.ak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileOperations {

	String dirToSearch;
	String fileFilter;
	HashMap<String, Integer> fileLineCounts;

	public void fileReader(String filePath, String extension) throws Exception {
		dirToSearch = filePath;
		fileFilter = extension;

		File directory = new File(dirToSearch);

		File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(extension.toLowerCase()));
		if (files == null) {
			System.out.println("Files array is empty");
			return;
		}

		HashMap<String, Integer> fileLineCounts = new HashMap<>();

		for (File file : files) {
			FileReader reader = new FileReader(file);
			BufferedReader bf = new BufferedReader(reader);

			String word;
			int count = 0;
			try {
				Scanner scanner = new Scanner(new File(file.getAbsolutePath()));
				while (scanner.hasNext()) {
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			fileLineCounts.put(file.getName(), count);

			System.out.println(file.getName() + " has " + count + " lines");
		}

	}

}
