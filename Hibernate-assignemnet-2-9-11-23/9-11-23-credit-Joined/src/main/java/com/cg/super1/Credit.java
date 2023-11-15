package com.cg.super1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="credit_join")

public class Credit extends Account{
	@Column(name="overDueLimit")
	private float overDueLimit;
	public Credit() {
		super();
	}

	public Credit(float overDueLimit) {
		super();
		this.overDueLimit = overDueLimit;
	}

	public float getOverDueLimit() {
		return overDueLimit;
	}

	public void setOverDueLimit(float overDueLimit) {
		this.overDueLimit = overDueLimit;
	}

	@Override
	public String toString() {
		return "Credit [overDueLimit=" + overDueLimit + ", getOverDueLimit()=" + getOverDueLimit() + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getBalance()=" + getBalance() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}
