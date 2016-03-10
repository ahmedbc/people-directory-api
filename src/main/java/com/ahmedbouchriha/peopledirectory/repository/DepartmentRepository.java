package com.ahmedbouchriha.peopledirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedbouchriha.peopledirectory.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findByCompanyId(Long id);
}
