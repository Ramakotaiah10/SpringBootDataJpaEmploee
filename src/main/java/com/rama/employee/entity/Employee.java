package com.rama.employee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_TBL")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMP_NO")
	private Integer empNo;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_SALARY")
	private Double empSal;
	
	@Column(name="EMP_EMAIL")
	private String empEmail;
	
	@Column(name="EMP_EXPERIENCE")
	private Integer empExperience;
	
	@Column(name="EMP_DESIGNATION")
	private String empDesignation;

}
