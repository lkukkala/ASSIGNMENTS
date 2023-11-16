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

import com.cg.entity.Department;
import com.cg.service.DepartmentService;

import jakarta.validation.Valid;

import com.cg.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	@Autowired
	DepartmentService service;
	@GetMapping("/hello")
	public String printHello() {
		return "Hii Spring";
	}
	
		//@GetMapping("/departments")
	@GetMapping(path="/departments",produces= {MediaType.APPLICATION_JSON_VALUE})
	//@GetMapping(path="/departments",produces= {MediaType.APPLICATION_ATOM_XML_VALUE})
	public List<Department>viewDepartmentList() {
		System.out.println("Helo");
		List<Department> listDepartments = service.listAll();
		return listDepartments;
	}
	
	@GetMapping("/departments/{did}")
		public Optional<Department> findByDepartment(@PathVariable int did) {
			return service.getDepartment(did);
		}
	@PostMapping("/departments")
	public Department createDepartment(@Valid @RequestBody Department newDepartment) {
		return service.createDepartment(newDepartment);
	}
	
	@DeleteMapping("/departments/{id}")
	public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id")Integer deptId){
		return service.deleteDepartment(deptId);
	}
	@PutMapping("/departments/{id}")
	public String updateDepartment(@PathVariable(value = "id")Integer id,@Valid @RequestBody Department newDepartment){
		return service.updateDepartment(id,newDepartment);
	}

}
