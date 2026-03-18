package com.gal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gal.model.Department;
import com.gal.model.DepartmentRepository;

@Component
public class DepartmentServiceImpl implements DepartmentService {

	DepartmentRepository deptRepo;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}

	@Override
	public List<Department> findAll() {
		return deptRepo.findAll();
		// TODO Auto-generated method stub

	}

	@Override
	public void addDepartment(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public void updateDepartment(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public void deleteDepartment(int deptId) {
		deptRepo.deleteById(deptId);

	}

	@Override
	public Department find(int department_Id) {
		return deptRepo.findById(department_Id).orElse(null);

	}
}
