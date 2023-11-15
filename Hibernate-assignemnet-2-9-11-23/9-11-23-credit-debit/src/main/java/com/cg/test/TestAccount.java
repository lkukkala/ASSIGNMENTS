package com.cg.test;

import com.cg.super1.Account;
import com.cg.util.CrudOperationsAcc;
import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class TestAccount {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		CrudOperationsAcc b=new CrudOperationsAcc();
		b.insertEntity();
b.findEntity();
//b.updateEntity();
	b.removeEntity();
	}
	
	

}
