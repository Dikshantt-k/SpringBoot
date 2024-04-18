package com.example.SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.entity.Department;
import com.example.SpringBoot.service.DepartmentService;
import com.example.SpringBoot.service.DepartmentServiceImpl;



@RestController

public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	
	}
	
	@GetMapping("/departments") 
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartment();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id")Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted !!!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable ("id")Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchByDepartmentName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
		}
}