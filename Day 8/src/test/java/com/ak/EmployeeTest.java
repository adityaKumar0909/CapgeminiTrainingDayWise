package com.ak;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void insertEmployee() {

		Employee e = new Employee("Rahul", 45000);

		EmployeeDao.save(e);

		System.out.println("Inserted successfully");
	}

}
