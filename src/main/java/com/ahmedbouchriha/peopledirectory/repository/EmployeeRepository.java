package com.ahmedbouchriha.peopledirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedbouchriha.peopledirectory.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findBydepartmentId(Long id);
}
