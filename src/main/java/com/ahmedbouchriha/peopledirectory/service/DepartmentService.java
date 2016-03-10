package com.ahmedbouchriha.peopledirectory.service;

import java.util.List;

import com.ahmedbouchriha.peopledirectory.domain.Department;

public interface DepartmentService {

	Department save(Department department);

	/*List<department> getList();*/

	void deletedepartment(Department department);

	Department finddepartmentById(Long id);

	//void updatedepartment(department u);

	List<Department> getdepartmentsByComanyId(Long id);
}
