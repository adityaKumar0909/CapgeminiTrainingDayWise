package com.ak;

import java.util.List;

import jakarta.persistence.EntityManager;

public class MainApp {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();

		String jpql = "SELECT e FROM Employee e WHERE e.salary >= :sal";

		List<Employee> list = em.createQuery(jpql, Employee.class).setParameter("sal", 50000).getResultList();

		for (Employee e : list) {
			System.out.println(e.name);
		}
	}
}
