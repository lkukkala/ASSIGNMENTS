package com.cg.super1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="debit_join")
public class Debit extends Account{
	@Column(name="interest")
	private float interest;

	public Debit() {
		super();
	}

	public Debit(float interest) {
		super();
		this.interest = interest;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Debit [interest=" + interest + ", getInterest()=" + getInterest() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
