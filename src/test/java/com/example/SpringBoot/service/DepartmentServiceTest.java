package com.example.SpringBoot.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.SpringBoot.entity.Department;
import com.example.SpringBoot.repository.DepartmentRepository;
@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp()  {
		Department department = Department.builder()
							.departmentName("Mechanical")
							.departmentAddress("mumbai")
							.departmentCode("me-01")
							.departmentId(1L)
							.build();
		Mockito.when(departmentRepository.findByDepartmentName("Mechanical"))
				.thenReturn(department);
		
		
	}
	@Test
	@DisplayName("Get data based on valid on department name")
	public void whenValidDepartmentName_thenDEpartmentSholdFound() {
		String departmentName="Mechanical";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName,found.getDepartmentName());
		
	}
	
//	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
