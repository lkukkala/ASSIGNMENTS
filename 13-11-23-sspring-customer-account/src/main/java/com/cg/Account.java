package com.cg;

public class Account {
	private int id;
	private String holderName;
	private float balance;
	
	public Account() {
		super();
	}
	public Account(int id, String holderName) {
		super();
		this.id = id;
		this.holderName = holderName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHolderName() {
		return holderName;
	}


	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", holderName=" + holderName + ", balance=" + balance + "]";
	}


	
	
	
	
	

}
