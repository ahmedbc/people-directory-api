package com.ahmedbouchriha.peopledirectory.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedbouchriha.peopledirectory.domain.Company;
import com.ahmedbouchriha.peopledirectory.service.CompanyService;
import com.ahmedbouchriha.peopledirectory.service.exception.CompanyAlreadyExistsException;


@RestController
@PreAuthorize("permitAll")
public class CompanyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
	private final CompanyService companyService;

	@Inject
	public CompanyController(final CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@RequestMapping(value = "/company/add", method = RequestMethod.POST)
	public Company createCompany(@ModelAttribute @Valid final Company company) {
		LOGGER.debug("Received request to create the {}", company);
		return companyService.save(company);
	}
	
	@RequestMapping(value = "/company/getAll", method = RequestMethod.GET)
	public List<Company> listCompanies() {
		LOGGER.debug("Received request to list all companies");
		return companyService.getList();
	}
	

	@RequestMapping(value = "/company/{id}/delete", method = RequestMethod.DELETE)
	public void deleteCompany(@PathVariable("id") Long id) {
		Company u = companyService.findCompanyById(id);
		companyService.deleteCompany(u);
	}

	/*@RequestMapping(value = "/updateCompany", method = RequestMethod.PUT)
	public void updateCompany(@RequestBody Company u) {
		companyService.updateCompany(u);
	}

	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public Company findCompanyById(@PathVariable("id") Long id) {
		return companyService.findCompanyById(id);
	}*/

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleCompanyAlreadyExistsException(CompanyAlreadyExistsException e) {
		return e.getMessage();
	}

}
