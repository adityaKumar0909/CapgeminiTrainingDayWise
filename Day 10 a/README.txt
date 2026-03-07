Submission by : Aditya Kumar
Email id: kadi93030@gmail.com


Questions :

1. Write the query to find all suppliers name.

2. Write query to find the suppliers from Dehi.

3. Find the names of items supplieed by supplier with sid = 1.

Answers:

1.  List<String> supplierNames = em.createQuery("SELECT s.Sname FROM Supplier s", String.class).getResultList();
			System.out.println("Supplier Names: " + supplierNames);

2.  List<String> suppliersFromDelhi = em
					.createQuery("SELECT s.Sname FROM Supplier s WHERE s.city = 'Delhi'", String.class).getResultList();
			System.out.println("Suppliers from Delhi: " + suppliersFromDelhi);
3.  List<String> itemsSuppliedBySupplier1 = (List<String>) em
					.createQuery("SELECT i.name FROM Supply s JOIN s.item i WHERE s.supplier.Sid = 1", String.class)
					.getResultList();
			System.out.println("Items supplied by supplier with Sid=1: " + itemsSuppliedBySupplier1);
