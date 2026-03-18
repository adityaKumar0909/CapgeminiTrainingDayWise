package com.gal;

import java.util.List;

import com.gal.model.Department;

public interface DepartmentDao {

	Department find(int deptId);

	List<Department> findAll();

	void addDepartment(Department dept);

	void updateDepartment(Department dept);

	void deleteDepartment(int deptId);

}
