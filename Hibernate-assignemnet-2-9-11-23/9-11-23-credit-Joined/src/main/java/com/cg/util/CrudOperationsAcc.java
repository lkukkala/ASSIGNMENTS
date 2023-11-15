package com.cg.util;

import java.util.Scanner;

import com.cg.super1.Account;

import jakarta.persistence.EntityManager;

public class CrudOperationsAcc {
	
	public void insertEntity() {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id: ");
		int id=sc.nextInt();
		System.out.println("Enter name: ");
		String name=sc.next();
		System.out.println("Enter balance");
		float bal=sc.nextFloat();
		Account a=new Account(id,name,bal);
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public void findEntity() {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter input");
		Scanner sc=new Scanner(System.in);
		Account e1=em.find(Account.class, sc.nextInt());
		System.out.println(e1);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateEntity() {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter input");
		Scanner sc=new Scanner(System.in);
		int id =sc.nextInt();
		Account e1=em.find(Account.class, id);
		System.out.println("Enter the name to be modified: ");
		String name=sc.next();
		System.out.println("Enter the balnce to be modified: ");
		float balance=sc.nextFloat();
		Account a=new Account(id,name,balance);
		em.persist(a);
		System.out.println(a);
		em.getTransaction().commit();
		em.close();	
	}
	
	public void removeEntity() {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter input");
		Scanner sc=new Scanner(System.in);
		Account e1=em.find(Account.class, sc.nextInt());
		System.out.println(e1);
		em.remove(e1);
		em.getTransaction().commit();
		em.close();
	}

}
