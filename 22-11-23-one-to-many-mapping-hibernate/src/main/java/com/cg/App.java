package com.cg;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.cg.entity.Department;
import com.cg.entity.Employee;

import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class App {
	public static void main(String[] args) throws IOException {	
		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Employee emp1=new Employee("lavanya","lavanya@gmail.com",2500.9);
		Employee emp2=new Employee("kavya","kavya@gmail.com",27929.2);
		Set<Employee> employees=new HashSet<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		
		Department dept=new Department();
		dept.setName("IT");
		dept.setEmployees(employees);
		
		entitymanager.persist(dept);
		entitytransaction.commit();
		entitymanager.close();
}
}
