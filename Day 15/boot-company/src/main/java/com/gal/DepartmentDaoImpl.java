package com.gal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Department find(int deptId) {
		EntityManager em = emf.createEntityManager();
		Department dept = em.find(Department.class, deptId);
		return dept;

	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Department", Department.class).getResultList();
	}

	@Override
	public void addDepartment(Department dept) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(dept);

	}

	@Override
	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

	}

	@Override
	public void deleteDepartment(int deptId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Department.class, deptId));

	}

}
