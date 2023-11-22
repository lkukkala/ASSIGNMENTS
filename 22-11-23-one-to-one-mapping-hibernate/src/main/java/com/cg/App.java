package com.cg;

import java.io.IOException;
import java.util.Scanner;

import com.cg.entity.Address;
import com.cg.entity.Employee;
import com.cg.util.AddressDAO;
import com.cg.util.CRUDOperations;
import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class App {
	public static void main(String[] args) throws IOException {	
		CRUDOperations c=new CRUDOperations();
		c.insertEntity();
	c.findEntity();
		c.updateEntity();
		//c.removeEntity();
		
}
}
