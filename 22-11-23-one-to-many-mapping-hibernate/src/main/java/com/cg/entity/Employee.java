package com.cg.entity;



import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="employeetables")
public class Employee {
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	
	private String employeeName;
	
	@Column(name="email",unique=true)
	private String email;

	@Column(name="salary")
	private Double salary;
	

	
	
	
	public Employee( ) {}
	
	public Employee( String employeeName, String email,  Double salary) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		
		this.salary = salary;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	

	
}