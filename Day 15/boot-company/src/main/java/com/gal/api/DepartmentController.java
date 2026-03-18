package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService deptService;

	@RequestMapping("/department")
	@ResponseBody
	public String getDepartment() {
		Department department = deptService.find(10);
		return department.toString();
	}

}
