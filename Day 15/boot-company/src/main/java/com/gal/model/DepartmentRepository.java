package com.gal.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    //Find department from name
    @Query(value = "select * from Department d where d.depname=:depname",nativeQuery = true)
    Department findByName(String name);

    //Find department with no manager
    @Query(value = "select * from Department d where d.managerId is null",nativeQuery = true)
    Department findByManagerId();

    //Find department who is the youngest
    @Query(value = "select * from Department d where d.deptId in (select e.departmentId from Employee e where e.hireDate = (select min(hireDate) from Employee))",nativeQuery = true)
    Department findYoungestDepartment();

    //find department whose manager name is given
    @Query(value = "select * from Department d where d.deptId in ( select e.departmentId from Employee e where e.empName = :empName and e.department)",nativeQuery = true)
    Department findDepartmentManagerName(String empName);
}
