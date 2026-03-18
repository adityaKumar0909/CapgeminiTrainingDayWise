package com.gal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.gal.model.Department;
import com.gal.service.DepartmentService;
import com.gal.service.DepartmentServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.gal")
public class BootCompanyApplication {

	private final DepartmentServiceImpl deptServiceImpl;

	BootCompanyApplication(DepartmentServiceImpl deptServiceImpl) {
		this.deptServiceImpl = deptServiceImpl;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootCompanyApplication.class, args);
		DepartmentService deptService = context.getBean(DepartmentService.class);

		deptService.addDepartment(new Department(1, "HR"));
		deptService.addDepartment(new Department(2, "IT"));
		deptService.addDepartment(new Department(3, "Finance"));
		deptService.findAll().forEach(System.out::println);

	}

}
