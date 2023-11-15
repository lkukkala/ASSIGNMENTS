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
	
	@RequestMapping("/")
	 public String viewHomePage(Model model) {
		List<Customer> listDetails=service.listAll();
		model.addAttribute("listCustomers",listDetails);
		for(Customer c:listDetails) {
			System.out.println("data"+c.getId()+c.getName());
		}
		return "index";
		 
	 }
	@RequestMapping("/new")
	public String showProductPage(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "new_customer";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("customer")Customer customer) {
		System.out.println("customer: "+customer);
		service.save(customer);
		return "redirect:/";
		
		
	}
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name="id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
	@RequestMapping("edit/{id}")
	public ModelAndView showEditCustomerPage(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_customer");
		Customer customer=service.get(id);
		mav.addObject("customer",customer);
		return mav;
	}


}
