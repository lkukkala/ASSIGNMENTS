package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AddressTable1")
public class Address {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;    
	private String city;    
	private int pincode;  
	//@OneToOne(targetEntity=Employee.class)  
	//private Employee employee;
	public Address() {
		super();
	}
	
	public Address(int id, String city, int pincode) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return id;
	}
	public void setAddressId(int addressId) {
		this.id = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	/*public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}  */
	
	

}
