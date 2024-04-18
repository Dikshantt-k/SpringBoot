package com.example.SpringBoot.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringBoot.entity.Department;

import jakarta.persistence.EntityManager;
//@SpringBootTest
//@AutoConfigureTestDatabase
@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp(){
		Department department = Department.builder()
				.departmentName("It")
				.departmentCode("It-01")
				.departmentAddress("delhi")
				.build();
		entityManager.persist(department);
	}

	
	@Test
	public void whenFindById_thenReturnDepartment() {
			Department department = departmentRepository.findById(1L).get();
			assertEquals(department.getDepartmentName(), "It");
		}
	}


