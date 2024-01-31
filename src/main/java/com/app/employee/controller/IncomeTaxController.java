package com.app.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.employee.entity.IncomeTaxRequest;
import com.app.employee.service.impl.IncomeTaxService;

@RestController
public class IncomeTaxController {

	@Autowired
	private IncomeTaxService service;

	@PostMapping("/income")
	public ResponseEntity<Object> incomeTax(@RequestBody IncomeTaxRequest request) {
		return new ResponseEntity<>(service.calculatingIncomeTax(request), HttpStatus.OK);
	}

}
