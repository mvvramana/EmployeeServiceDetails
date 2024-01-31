package com.app.employee.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.app.employee.entity.IncomeTaxRequest;
import com.app.employee.entity.IncomeTaxResponse;

@Service
public class IncomeTaxService {

	public IncomeTaxResponse calculatingIncomeTax(IncomeTaxRequest request) {
		IncomeTaxResponse incomeTaxResponse = new IncomeTaxResponse();
		incomeTaxResponse = this.incomeTaxResponse(request.getSalary());
		return incomeTaxResponse;

	}

	protected IncomeTaxResponse incomeTaxResponse(BigDecimal salary) {
		IncomeTaxResponse response = new IncomeTaxResponse();
		if (salary.compareTo(new BigDecimal(250000)) <= 0) {
			response.setIncomeTaxResponse(salary, new BigDecimal(0), "0%");
			return response;
		}
		if (salary.compareTo(new BigDecimal(250001)) >= 0 && salary.compareTo(new BigDecimal(500000)) <= 0) {
			return this.setIncomeTaxResponse(salary, 0.05, "5%");

		}
		if (salary.compareTo(new BigDecimal(500001)) >= 0 && salary.compareTo(new BigDecimal(1000000)) <= 0) {
			return this.setIncomeTaxResponse(salary, 0.1, "10%");

		}
		if (salary.compareTo(new BigDecimal(1000001)) >= 0) {
			return this.setIncomeTaxResponse(salary, 0.2, "20%");

		}
		return response;

	}

	protected IncomeTaxResponse setIncomeTaxResponse(BigDecimal salary, Double tax, String taxPercentage) {
		IncomeTaxResponse response = new IncomeTaxResponse();
		BigDecimal taxOnSalary = salary.multiply(new BigDecimal(tax));
		BigDecimal netIncome = salary.subtract(taxOnSalary);
		response.setIncomeTaxResponse(netIncome, taxOnSalary, taxPercentage);
		return response;

	}
}
