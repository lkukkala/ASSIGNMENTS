package com.cg.util;

import com.cg.entity.Address;
import com.cg.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CRUDOperations {
	
	public void insertEntity() {
		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		Employee emp=new Employee();
		emp.setEmployeeName("Vanitha");
	
		Address address=new Address();
		
		address.setCity("hyd");
		emp.setAddress(address);
		System.out.println(emp);
		
		entitymanager.persist(emp);
		entitytransaction.commit();
		entitymanager.close();
	}

	public void findEntity() {
		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Employee empobj = entitymanager.find(Employee.class, 2);
		System.out.println(empobj);
		entitytransaction.commit();
		entitymanager.close();
	}

	public void updateEntity() {

		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Employee empobj = entitymanager.find(Employee.class, 2);
		System.out.println(empobj);
		empobj.setEmployeeName("john");
		entitytransaction.commit();
		entitymanager.close();

	}

	public void removeEntity() {
		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Employee empObj = entitymanager.find(Employee.class, 2);
		entitymanager.remove(empObj);
		entitytransaction.commit();
		entitymanager.close();
	}

}
