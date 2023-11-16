package com.cg.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;

import jakarta.validation.Valid;

import com.cg.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@GetMapping("/hello")
	public String printHello() {
		return "Hii Spring";
	}
	
		//@GetMapping("/employees")
	@GetMapping(path="/employees",produces= {MediaType.APPLICATION_JSON_VALUE})
	//@GetMapping(path="/employees",produces= {MediaType.APPLICATION_ATOM_XML_VALUE})
	public List<Employee>viewEmployeeList() {
		System.out.println("Helo");
		List<Employee> listEmployees = service.listAll();
		return listEmployees;
	}
	
	@GetMapping("/employees/{eid}")
		public Optional<Employee> findByEmployee(@PathVariable int eid) {
			return service.getEmployee(eid);
		}
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee newEmployee) {
		return service.createEmployee(newEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id")Integer employeeId){
		return service.deleteEmployee(employeeId);
	}
	@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable(value = "id")Integer id,@Valid @RequestBody Employee newEmployee){
		return service.updateEmployee(id,newEmployee);
	}

}
