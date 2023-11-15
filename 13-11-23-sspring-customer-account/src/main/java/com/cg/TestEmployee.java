package com.cg;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestEmployee {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer emp=(Customer) context.getBean("empbean",Customer.class);
		System.out.println(emp);
		Customer emp1=(Customer) context.getBean("updateEmp",Customer.class);
		System.out.println(emp1);	
		Customer emp2=(Customer) context.getBean("custdetails",Customer.class);
		System.out.println(emp2);
		

	}

}
