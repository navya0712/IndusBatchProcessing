package com.indus.training.persist.dao;

import java.util.ArrayList;
import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exceptions.EmployeeDaoException;
import com.indus.training.persist.impl.EmployeeDaoImpl;

import junit.framework.TestCase;

public class TestEmployeeDaoImpl extends TestCase {

	private EmployeeDaoImpl employeeDAO = null;

	protected void setUp() throws Exception {
		employeeDAO = new EmployeeDaoImpl();
	}

	protected void tearDown() throws Exception {
		employeeDAO = null;
	}

	public void testBatchInsertEmployees() {
		List<Employee> employeesToInsert = new ArrayList<>();
		try {
			for (int i = 1; i <= 25; i++) {
				Employee employee = new Employee();
				employee.setFirstName("FirstName" + i);
				employee.setLastName("LastName" + i);
				employeesToInsert.add(employee);
			}

			employeeDAO.batchInsertEmployees(employeesToInsert);
			for (Employee insertedEmployee : employeesToInsert) {
				Employee fetchedEmployee = employeeDAO.fetchEmployeeById(insertedEmployee.getEmployeeId());
				assertNotNull(fetchedEmployee);
				assertEquals(insertedEmployee.getFirstName(), fetchedEmployee.getFirstName());
				assertEquals(insertedEmployee.getLastName(), fetchedEmployee.getLastName());
			}

		} catch (Exception e) {
			fail("Exception thrown during batch insert test: " + e.getMessage());
		} finally {
			for (Employee insertedEmployee : employeesToInsert) {
				try {
					employeeDAO.deleteEmployeeById(insertedEmployee.getEmployeeId());
				} catch (EmployeeDaoException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void testBatchUpdateEmployees() {
		List<Employee> employeesToInsert = new ArrayList<>();
	    try {
	        for (int i = 1; i <= 10; i++) {
	            Employee employee = new Employee();
	            employee.setFirstName("FirstName" + i);
	            employee.setLastName("LastName" + i);
	            employeesToInsert.add(employee);
	        }

	        employeeDAO.batchInsertEmployees(employeesToInsert); 
	        for (Employee employee : employeesToInsert) {
	            employee.setLastName("UpdatedLastName" + employee.getEmployeeId()); // Update last names
	        }
	        employeeDAO.batchUpdateEmployees(employeesToInsert);
	        for (Employee employee : employeesToInsert) {
	            Employee updatedEmployee = employeeDAO.fetchEmployeeById(employee.getEmployeeId());
	            assertNotNull(updatedEmployee);
	            assertEquals("UpdatedLastName" + employee.getEmployeeId(), updatedEmployee.getLastName());
	        }

	    } catch (Exception e) {
	        fail("Exception thrown during batch update test: " + e.getMessage());
	    } finally {
	        for (Employee employee : employeesToInsert) {
	            try {
					employeeDAO.deleteEmployeeById(employee.getEmployeeId());
				} catch (EmployeeDaoException e) {
					e.printStackTrace();
				}
	        }
	    }
	}

}
