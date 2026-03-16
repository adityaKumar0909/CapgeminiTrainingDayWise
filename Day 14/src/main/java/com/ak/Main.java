package com.ak;

import java.util.HashMap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.ak");
		context.refresh();
		FileOperations bean = context.getBean(FileOperations.class);
		try {
			bean.fileReader("C:\\Users\\Aditya\\Desktop\\DayWiseProgressRepo\\CapgeminiTrainingDayWise\\Day 3",
					".java");
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (HashMap.Entry<String, Integer> entry : bean.fileLineCounts.entrySet()) {
			System.out.println(entry.getKey() + " has " + entry.getValue() + " lines");
		}
	}
}
