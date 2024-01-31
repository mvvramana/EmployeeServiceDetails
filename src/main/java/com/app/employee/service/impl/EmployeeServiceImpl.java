package com.app.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.employee.entity.Employee;
import com.app.employee.exception.EmployeeNotFoundException;
import com.app.employee.repo.EmployeeRepository;
import com.app.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Long createEmployee(Employee employee) {
		employee = repo.save(employee);
		return employee.getEmpId();
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Employee findEmployeeById(Long id) {
		/*
		 * Optional<Employee> opt = repo.findById(id); if (opt.isPresent()) return
		 * opt.get(); else throw new
		 * EmployeeNotFoundException("Employee '"+id+"' not exists!");
		 */

		return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee '" + id + "' not exists!"));
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// repo.deleteById(id);
		repo.delete(findEmployeeById(id));
	}

	@Override
	public void updateEmployee(Employee employee) {
		Long id = employee.getEmpId();
		if (id != null && repo.existsById(id)) {
			repo.save(employee);
		} else {
			throw new EmployeeNotFoundException("Employee '" + id + "' not exists!");
		}

	}

}
