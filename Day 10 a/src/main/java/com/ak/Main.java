package com.ak;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Item;
import model.Supplier;
import model.Supply;

public class Main {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			Supplier s2 = new Supplier();
			s2.setSname("Aditya");
			s2.setSrank("A");
			s2.setCity("Allahabad");

			Item i2 = new Item();
			i2.setName("Mocha");
			i2.setType("Drinkables");

			Supply sp2 = new Supply();
			sp2.setSupplier(s2);
			sp2.setItem(i2);
			sp2.setQuantity(10);
			sp2.setPrice(50000);
			sp2.setDatesupply("2024-06-01");

			et.begin();
			em.persist(s2);
			em.persist(i2);
			em.persist(sp2);
			et.commit();
			System.out.println("Supply record created successfully.");

			// Questions :
			// 1. Write the query to find all suppliers name
			List<String> supplierNames = em.createQuery("SELECT s.Sname FROM Supplier s", String.class).getResultList();
			System.out.println("Supplier Names: " + supplierNames);

			// 2. Write query to find the suppliers from Delhi
			List<String> suppliersFromDelhi = em
					.createQuery("SELECT s.Sname FROM Supplier s WHERE s.city = 'Delhi'", String.class).getResultList();
			System.out.println("Suppliers from Delhi: " + suppliersFromDelhi);

//			 //3.Find the names of items supplied by supplier with sid = 1

			List<String> itemsSuppliedBySupplier1 = (List<String>) em
					.createQuery("SELECT i.name FROM Supply s JOIN s.item i WHERE s.supplier.Sid = 1", String.class)
					.getResultList();
			System.out.println("Items supplied by supplier with Sid=1: " + itemsSuppliedBySupplier1);

		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

}