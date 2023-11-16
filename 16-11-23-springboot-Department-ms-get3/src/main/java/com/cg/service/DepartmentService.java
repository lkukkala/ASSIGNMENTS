package com.cg.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;

import com.cg.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository deptRepo;
	public Optional<Department> getDepartment(int id){
		Optional<Department> d=deptRepo.findById(id);
		return d;
	}
	public List<Department> getDepartmentFromDatabase(){
		return deptRepo.findAll();
	}
	public List<Department> listAll(){
		List<Department> departments=deptRepo.findAll();
		System.out.println(departments);
		return departments;
	}
	public Department createDepartment(Department department) {
		return deptRepo.save(department);
	}
	public Map<String,Boolean> deleteDepartment(Integer deptId){

		deptRepo.deleteById(deptId);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Department has been deleted", Boolean.TRUE);
		return response;
	}	
	public String updateDepartment(Integer deptId, Department newDepartment) {
		Optional<Department> existingDepartment = deptRepo.findById(deptId);
		if(existingDepartment.isPresent()) {
			Department foundDepartment = existingDepartment.get();
			foundDepartment.setDeptName(newDepartment.getDeptName());
			
			deptRepo.save(foundDepartment);
 
			return "employee Updated";
		}
		return "employee Not Updated";

	}

}
