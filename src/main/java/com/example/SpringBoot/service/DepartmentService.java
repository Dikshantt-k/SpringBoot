package com.example.SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.entity.Department;



public interface DepartmentService{

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartment();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

	

}

