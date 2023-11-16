package com.cg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;


@Service
@org.springframework.transaction.annotation.Transactional
public class CustomerService {
	@Autowired
private CustomerRepository repo;
	public List<Customer> listAll(){
		List<Customer> customer=repo.findAll();
		System.out.println(customer);
	    return customer;
	}
	public void save(Customer customer) {
		repo.save(customer);
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public Customer get(Long id) {
		 
		return repo.findById(id).get();

	}
}
