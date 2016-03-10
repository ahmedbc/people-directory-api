package com.ahmedbouchriha.peopledirectory.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedbouchriha.peopledirectory.domain.Department;
import com.ahmedbouchriha.peopledirectory.service.DepartmentService;
import com.ahmedbouchriha.peopledirectory.service.exception.DepartmentAlreadyExistsException;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	private final DepartmentService departmentService;

	@Inject
	public DepartmentController(final DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value = "/department/add", method = RequestMethod.POST)
	public Department createdepartment(@ModelAttribute @Valid final Department department) {
		LOGGER.debug("Received request to create the {}", department);
		System.out.println(department.getCompany().getId());
		System.out.println(department.getCompany().getName());
		return departmentService.save(department);
	}
	
	@RequestMapping(value = "/company/{id}/departments", method = RequestMethod.GET)
	public List<Department> getdepartmentsByComanyId(@PathVariable("id") Long id) {
		LOGGER.debug("Received request to list all departments");
		return departmentService.getdepartmentsByComanyId(id);
	}

	/*@RequestMapping(value = "/alldepartments", method = RequestMethod.GET)
	public List<department> listdepartments() {
		LOGGER.debug("Received request to list all departments");
		return departmentService.getList();
	}*/


	@RequestMapping(value = "/department/{id}/delete", method = RequestMethod.DELETE)
	public void deletedepartment(@PathVariable("id") Long id) {
		Department u = departmentService.finddepartmentById(id);
		departmentService.deletedepartment(u);
	}

	/*@RequestMapping(value = "/updatedepartment", method = RequestMethod.PUT)
	public void updatedepartment(@RequestBody department u) {
		departmentService.updatedepartment(u);
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
	public department finddepartmentById(@PathVariable("id") Long id) {
		return departmentService.finddepartmentById(id);
	}*/

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handledepartmentAlreadyExistsException(DepartmentAlreadyExistsException e) {
		return e.getMessage();
	}

}
