package com.gal;

public class EntityManagerFactoryConnectionMain {

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDao();

        // FETCH EXISTING
        Employee emp = dao.getEmployee(100);
        System.out.println(emp);

        // INSERT NEW
        Employee newEmp = new Employee();
        newEmp.setEmployeeId(999);
        newEmp.setFirstName("Aditya");
        newEmp.setLastName("Sharma");

        dao.insertEmployee(newEmp);

        // UPDATE
        newEmp.setLastName("Updated");
        dao.updateEmployee(newEmp);

        // DELETE
        // dao.deleteEmployee(999);

        EntityManagerFactoryProvider.closeFactory();
    }
}