package com.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.employee.entity.Employee;
import com.app.employee.exception.EmployeeNotFoundException;
import com.app.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

	// 1. create Employee
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		log.info("Entered into save method");
		ResponseEntity<String> response = null;
		try {
			Long id = service.createEmployee(employee);
			response = ResponseEntity.ok("Created with id: " + id);
			log.info("employee is created {}.", id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("About to leave save method");
		return response;
	}

	// 2. fetch all companies
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		ResponseEntity<List<Employee>> response = null;
		log.info("Entered into fetch all method");
		try {
			List<Employee> list = service.findAllEmployees();
			response = ResponseEntity.ok(list);
			log.info("Fetch method executed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("About to leave fetch all method");
		return response;
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable Long id) {
		ResponseEntity<?> resp = null;
		try {
			Employee employee = service.findEmployeeById(id);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw e; // call global exception handler
		}
		return resp;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		ResponseEntity<String> resp = null;
		try {
			service.deleteEmployeeById(id);
			resp = new ResponseEntity<String>("Employee " + id + " deleted!", HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw e; // call global exception handler
		}
		return resp;
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			service.updateEmployee(employee);
			resp = new ResponseEntity<String>("Employee '" + employee.getEmpId() + "' updated!", HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw e; // calls global handler
		}
		return resp;
	}

}
