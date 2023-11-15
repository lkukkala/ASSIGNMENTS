package com.cg.test;

import com.cg.super1.Account;
import com.cg.super1.Credit;
import com.cg.super1.Debit;
import com.cg.util.CrudOperationsAcc;
import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class TestAccount {

	public static void main(String[] args) {
		EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
//		CrudOperationsAcc b=new CrudOperationsAcc();
//		b.insertEntity();
//		b.findEntity();
//		b.updateEntity();
//		b.removeEntity();
		entityManager.getTransaction().begin();
		Credit c= new Credit();
		c.setName("Aravind");
		c.setBalance(5678.5f);
		c.setOverDueLimit(50000);
		Debit d=new Debit();
		d.setInterest(2);
		entityManager.persist(c);
		entityManager.persist(d);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		}
	
	

}
