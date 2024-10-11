package com.indus.training.persist.dao;

import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exceptions.EmployeeDaoException;

public interface IEmployeeDao {

	/**
	 * Inserts a new employee into the database.
	 * 
	 * @param empObj The Employee object to be inserted.
	 * @return true if the employee was successfully inserted, false otherwise.
	 * @throws EmployeeDaoException If there is an issue during the insertion.
	 */
	public Boolean insertEmployee(Employee employee) throws EmployeeDaoException;

	/**
	 * Fetches an employee by their ID.
	 * 
	 * @param empId The ID of the employee to fetch.
	 * @return The Employee object corresponding to the given ID.
	 * @throws EmployeeDaoException If there is an issue during the fetch.
	 */
	public Employee fetchEmployeeById(Integer employeeId) throws EmployeeDaoException;

	/**
	 * Updates the Employee Details of an employee by their ID.
	 * 
	 * @param empId    The ID of the employee to update.
	 * @param employee the employee details to be updated
	 * @return true if the update was successful, false otherwise.
	 * @throws EmployeeDaoException If there is an issue during the update.
	 */
	public Boolean updateEmployeeById(Integer employeeId, Employee employee) throws EmployeeDaoException;

	/**
	 * Deletes an employee by their ID.
	 * 
	 * @param empId The ID of the employee to delete.
	 * @return true if the deletion was successful, false otherwise.
	 * @throws EmployeeDaoException If there is an issue during the deletion.
	 */
	public Boolean deleteEmployeeById(Integer employeeId) throws EmployeeDaoException;

	public void batchInsertEmployees(List<Employee> employees);

	public void batchUpdateEmployees(List<Employee> employees);

}
