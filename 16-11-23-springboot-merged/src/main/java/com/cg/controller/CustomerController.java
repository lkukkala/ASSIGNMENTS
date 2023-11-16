package com.cg.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;

@Controller

public class CustomerController {
@Autowired                                                                                                                                                                                            
CustomerService service;
@RequestMapping("/c-api")
public String view(Model model) {
	List<Customer> listCustomer=service.listAll();
	model.addAttribute("listCustomer", listCustomer);
	for(Customer c:listCustomer) {
		System.out.println("data"+c.getId()+c.getName());
	}
	return "c_index";
}
@RequestMapping("/newcust")
public String showNewCustomerPage(Model model) {
	Customer customer=new Customer();
	model.addAttribute("customer",customer);
	return "new_customer";
}
@RequestMapping(value="/savecust",method=RequestMethod.POST)
public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	service.save(customer);
	return "redirect:/c-api";
}
@RequestMapping("/deletecust/{id}")
	public String deleteCustomer(@PathVariable(name="id")Long id) {
	service.delete(id);
	return "redirect:/c-api";
}
@RequestMapping("/editcust/{id}")
public ModelAndView showEditCustomerPage(@PathVariable(name="id") Long id) {
	ModelAndView mav=new ModelAndView("edit_customer");
	Customer customer=service.get(id);
	mav.addObject("customer",customer);
	return mav;
}
}



