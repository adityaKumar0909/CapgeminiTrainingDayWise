package com.gal;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDaoTest {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeDaoTest.class);

    private static EmployeeDao dao;

    @BeforeAll
    static void setup() {
        logger.info("Opening EntityManagerFactory...");
        dao = new EmployeeDao();
    }

    @Test
    @Order(1)
    void testInsertEmployee() {
        logger.info("Testing Insert Employee...");

        Employee emp = new Employee();
        emp.setEmployeeId(999);
        emp.setFirstName("Aditya");
        emp.setLastName("Sharma");

        dao.insertEmployee(emp);

        Employee fetched = dao.getEmployee(999);

        assertNotNull(fetched);
        assertEquals("Aditya", fetched.getFirstName());

        logger.info("Insert test passed.");
    }

    @Test
    @Order(2)
    void testGetEmployee() {
        logger.info("Testing Get Employee...");

        Employee emp = dao.getEmployee(999);

        assertNotNull(emp);
        logger.info("Fetched Employee: {}", emp);
    }

    @Test
    @Order(3)
    void testDeleteEmployee() {
        logger.info("Testing Delete Employee...");

        dao.deleteEmployee(999);

        Employee emp = dao.getEmployee(999);

        assertNull(emp);

        logger.info("Delete test passed.");
    }

    @AfterAll
    static void tearDown() {
        logger.info("Closing EntityManagerFactory...");
        EntityManagerFactoryProvider.closeFactory();
    }
}