package com.app.employee.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class IncomeTaxRequest {
	
	private Long empId;
	private BigDecimal salary;

}
