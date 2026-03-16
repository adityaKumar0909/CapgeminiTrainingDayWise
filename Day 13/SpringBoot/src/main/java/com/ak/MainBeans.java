package com.ak;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBeans {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// Which packages to scan for Annotations @Component)
		// Component Scan
		context.scan("com.ak");
		context.refresh();
		PasswordHasher bean = context.getBean(PasswordHasher.class);
		System.out.println(bean);
		System.out.println(bean.hash("hello"));
		StringBuilder bean3 = context.getBean(StringBuilder.class);
		System.out.println(bean3);
		int sum = context.getBean(Calc.class).add(10, 20);
		System.out.println(sum);
		String[] beans = context.getBeanDefinitionNames();

		context.close();
	}
}
