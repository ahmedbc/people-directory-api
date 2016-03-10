package com.ahmedbouchriha.peopledirectory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedbouchriha.peopledirectory.domain.Employee;
import com.ahmedbouchriha.peopledirectory.service.EmployeeService;
import com.ahmedbouchriha.peopledirectory.service.exception.CompanyAlreadyExistsException;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	private final EmployeeService employeeService;

	@Inject
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody @Valid final Employee employee) {
		LOGGER.debug("Received request to create the {}", employee);
		return employeeService.save(employee);
	}
	
	// TODO move this api to the department
	@RequestMapping(value = "/department/{id}/employees", method = RequestMethod.GET)
	public List<Employee> getEmployeesBydepartmentId(@PathVariable("id") Long id) {
		LOGGER.debug("Received request to list all employees by department id");
		return employeeService.getEmployeesBydepartmentId(id);
		
	}

	/*@RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
	public List<Employee> listEmployees() {
		LOGGER.debug("Received request to list all employees");
		return employeeService.getList();
	}*/


	@RequestMapping(value = "/employee/{id}/delete", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") Long id) {
		Employee u = employeeService.findEmployeeById(id);
		employeeService.deleteEmployee(u);
	}

	/*@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee u) {
		employeeService.updateEmployee(u);
	}*/

	/*@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee findEmployeeById(@PathVariable("id") Long id) {
		return employeeService.findEmployeeById(id);
	}*/

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleEmployeeAlreadyExistsException(CompanyAlreadyExistsException e) {
		return e.getMessage();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
