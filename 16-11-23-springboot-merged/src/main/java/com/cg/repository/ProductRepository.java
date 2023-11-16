package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

//import com.cg.entity.Product1;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	
}
