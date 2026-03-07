package com.ak;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("supply_pu");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
