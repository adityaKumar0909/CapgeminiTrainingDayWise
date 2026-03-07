package com.ak.model;

import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trainingcapg_pu");
		EntityManager em = emf.createEntityManager();
		try {
			Trainee t1 = new Trainee();
			t1.setName("Rohit");
			t1.setEmail("Rohit@gmail.com");
			Batch b1 = new Batch();
			b1.setName("Java");
			Trainer tr1 = new Trainer();
			tr1.setName("Suresh");
			tr1.setCapgtrainerid(0);
			Teaching teaching1 = new Teaching();
			teaching1.setBatch(b1);
			teaching1.setTrainer(tr1);
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(tr1);
			em.persist(b1);
			em.persist(teaching1);
			em.persist(t1);
			et.commit();
			System.out.println("Created trainee: " + t1.getName());
		} finally {
			if (em != null && em.isOpen()) {

				em.close();
			}
			if (emf != null && emf.isOpen()) {
				emf.close();
			}
		}
	}

}