package com.ahmedbouchriha.peopledirectory.service;

import java.util.List;

import com.ahmedbouchriha.peopledirectory.domain.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	
	List<Employee> getEmployeesBydepartmentId(Long id);

	//List<Employee> getList();

	void deleteEmployee(Employee employee);

	Employee findEmployeeById(Long id);

	//void updateEmployee(Employee u);
}
