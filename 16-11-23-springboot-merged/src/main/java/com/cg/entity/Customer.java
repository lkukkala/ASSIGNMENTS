package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
@Table(name="Customer5")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long id;
	private String name;
private int balance;
public Customer(Long id, String name, int balance) {
	super();
	this.id = id;
	this.name = name;
	this.balance = balance;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]";
}
}
