package com.gal.service;

import java.util.List;

import com.gal.model.Department;

public interface DepartmentService {

	Department find(int department_Id);

	List<Department> findAll();

	void addDepartment(Department dept);

	void updateDepartment(Department dept);

	void deleteDepartment(int deptId);

}
