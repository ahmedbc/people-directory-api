package com.ahmedbouchriha.peopledirectory.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.ahmedbouchriha.peopledirectory.domain.Department;
import com.ahmedbouchriha.peopledirectory.repository.DepartmentRepository;
import com.ahmedbouchriha.peopledirectory.service.exception.DepartmentAlreadyExistsException;

@Service
@Validated
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	private final DepartmentRepository repository;

	@Inject
	public DepartmentServiceImpl(final DepartmentRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Department save(@NotNull @Valid final Department department) {
		LOGGER.debug("Creating {}", department);
		return repository.save(department);
	}
 
	/*@Override
	@Transactional(readOnly = true)
	public List<department> getList() {
		LOGGER.debug("Retrieving the list of all departments");
		return repository.findAll();
	}*/
	

	@Override
	@Transactional
	public void deletedepartment(Department department) {
		repository.delete(department);
	}

	@Override
	@Transactional
	public Department finddepartmentById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Department> getdepartmentsByComanyId(Long id) {
		// TODO Auto-generated method stub
		LOGGER.debug("Retrieving the list of departments by company id");
		return repository.findByCompanyId(id);
	}

	/*@Override
	@Transactional
	public void updatedepartment(department department) {
		repository.save(department);
	}*/

}
