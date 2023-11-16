package com.cg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;

import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	public Optional<Employee> getEmployee(int id){
		Optional<Employee> e=employeeRepo.findById(id);
		return e;
	}
	public List<Employee> getEmployeeFromDatabase(){
		return employeeRepo.findAll();
	}
	public List<Employee> listAll(){
		List<Employee> employees=employeeRepo.findAll();
		System.out.println(employees);
		return employees;
	}
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Map<String,Boolean> deleteEmployee(Integer employeeId){

		employeeRepo.deleteById(employeeId);
		Map<String,Boolean> response=new HashMap<>();
		response.put("employee has been deleted", Boolean.TRUE);
		return response;
	}	
	public String updateEmployee(Integer employeeId, Employee newEmployee) {
		Optional<Employee> existingEmployee = employeeRepo.findById(employeeId);
		if(existingEmployee.isPresent()) {
			Employee foundEmployee = existingEmployee.get();
			foundEmployee.setName(newEmployee.getName());
			foundEmployee.setSalary(newEmployee.getSalary());
			employeeRepo.save(foundEmployee);
 
			return "employee Updated";
		}
		return "employee Not Updated";

	}

}
