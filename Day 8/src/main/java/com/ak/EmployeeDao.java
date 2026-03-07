package com.ak;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {

	// Fetching employee
	public static Employee getEmployee(int id) {

		EntityManager em = EntityManagerFactoryProvider.getEntityManager();

		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;

	}

	public static void save(Employee emp) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(emp);
		tx.commit();

		em.close();
		System.out.println("employee data saved");
	}

	public static void update(Employee emp) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.merge(emp);
		tx.commit();

		em.close();
	}

	public static void delete(int id) {

		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Employee emp = em.find(Employee.class, id);

		if (emp != null) {
			em.remove(emp);
		}

		tx.commit();
		em.close();
	}

}
