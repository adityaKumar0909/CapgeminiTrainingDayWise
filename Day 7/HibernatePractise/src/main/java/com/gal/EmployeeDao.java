package com.gal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {

    public Employee getEmployee(int id) {
        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    public void insertEmployee(Employee employee) {
        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(employee);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateEmployee(Employee employee) {
        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(employee);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void deleteEmployee(int id) {
        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee emp = em.find(Employee.class, id);
            if (emp != null) {
                em.remove(emp);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}