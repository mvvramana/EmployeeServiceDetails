package com.app.employee.service;

import java.util.List;

import com.app.employee.entity.Employee;

public interface EmployeeService {
	Long createEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findEmployeeById(Long id);

	void deleteEmployeeById(Long id);

	void updateEmployee(Employee employee);
}
