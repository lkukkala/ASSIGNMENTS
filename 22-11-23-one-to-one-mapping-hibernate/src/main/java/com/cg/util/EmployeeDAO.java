package com.cg.util;

import com.cg.entity.Employee;

import jakarta.persistence.EntityManager;

public class EmployeeDAO {

	
		 public void saveEmployee(Employee employee) {
			 EntityManager em =JPAUtil.getEntityManagerFactory().createEntityManager(); 
	         em.getTransaction().begin( );  
	         System.out.println("Instructor:" + employee);
	         em.persist(employee);
	         em.getTransaction().commit(); 
	         em.close();             
		 }

	public void findEmployee(int id) {
	    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();
	    Employee emp= entityManager.find(Employee.class, id);
	    System.out.println(emp);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}

	public void updateEmployee(Employee employee) {
	    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();

	    Employee emp1 = entityManager.find(Employee.class, employee.getEmployeeId());
	    System.out.println("Found:"+ emp1);
	    // The entity object is physically updated in the database when the transaction
	    // is committed
	   emp1.setEmployeeId(emp1.getEmployeeId());
	    emp1.setEmployeeName(emp1.getEmployeeName());
	    emp1.setEmail(emp1.getEmail());
	   
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}

	public void removeEntity(int id ) {
	    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();
	    
	    Employee emp2 = entityManager.find(Employee.class, id);
	    System.out.println();
	    entityManager.remove(emp2);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}
	

	

}
