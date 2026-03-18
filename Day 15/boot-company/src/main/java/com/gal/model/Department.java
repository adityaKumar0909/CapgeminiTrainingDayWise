package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@Column(name = "department_id")
	Integer deptId;

	@Column(name = "department_name")
	String deptName;

	@Column(name = "manager_id")
	Integer managerId;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int i, String string) {
		this.deptId = i;
		this.deptName = string;

		// TODO Auto-generated constructor stub
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", managerId=" + managerId + "]";
	}

}
