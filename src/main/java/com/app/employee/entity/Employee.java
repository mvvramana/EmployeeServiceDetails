package com.app.employee.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_tab")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long empId;

	@NotNull(message = "first name must not be null")
	@Pattern(regexp = "[A-Z]{4,10}")
	@Column(name = "emp_first_name")
	private String empFirstName;

	@NotNull(message = "Last name must not be null")
	@Pattern(regexp = "[A-Z]{4,10}")
	@Column(name = "emp_last_name")
	private String empLastName;

	@NotNull(message = "email must not be null")
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
	@Column(name = "emp_email")
	private String email;

	@NotNull(message = "phone number can not be null")
	@Pattern(regexp = "[0-9]{10}")
	@Column(name = "emp_ph_number")
	private List<Long> phoneNumber;

	@NotNull(message = "join date can not be null")
	@Pattern(regexp = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")
	@Column(name = "emp_join_date")
	private Date dateOfJoin;

	@NotNull(message = "salary can not be null")
	@Min(1)
	@Max(9999999)
	@Column(name = "salary")
	private Double empSal;

}
