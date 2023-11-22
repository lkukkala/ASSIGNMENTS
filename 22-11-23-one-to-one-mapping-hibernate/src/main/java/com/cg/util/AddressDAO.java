package com.cg.util;

import com.cg.entity.Address;
import com.cg.entity.Employee;

import jakarta.persistence.EntityManager;

public class AddressDAO {
	public void saveAddress(Address address) {
		 EntityManager em =JPAUtil.getEntityManagerFactory().createEntityManager(); 
       em.getTransaction().begin( );  
       System.out.println("Employee:" + address);
       em.persist(address);
       em.getTransaction().commit(); 
       em.close();             
	 }

public void findEntity(int id) {
  EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
  entityManager.getTransaction().begin();
  Address address = entityManager.find(Address.class, id);
  System.out.println(address);
  entityManager.getTransaction().commit();
  entityManager.close();
}

public void updateEntity(Address address) {
  EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
  entityManager.getTransaction().begin();

  Address address1 = entityManager.find(Address.class, address.getAddressId());
  System.out.println("Found:"+ address1);
  // The entity object is physically updated in the database when the transaction
  // is committed
  address1.setAddressId(address1.getAddressId());
  address1.setCity(address1.getCity());
  address1.setPincode(address1.getPincode());
  
 
 
  entityManager.getTransaction().commit();
  entityManager.close();
}

public void removeEntity(int id ) {
  EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
  entityManager.getTransaction().begin();
  
  Employee employee = entityManager.find(Employee.class, id);
  System.out.println();
  entityManager.remove(employee);
  entityManager.getTransaction().commit();
  entityManager.close();
}
	

}
