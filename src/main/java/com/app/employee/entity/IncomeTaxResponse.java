package com.app.employee.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class IncomeTaxResponse {

	private String empCode;
	private String firstName;
	private String lastName;
	private BigDecimal netSalary;
	private BigDecimal taxOnSalary;
	private BigDecimal totalTax;
	private String taxRate;

	public void setIncomeTaxResponse(BigDecimal netSalary, BigDecimal taxOnSalary, String taxRate) {
		this.netSalary = netSalary;
		this.taxOnSalary = taxOnSalary;
		this.taxRate = taxRate;
	}

	
}
