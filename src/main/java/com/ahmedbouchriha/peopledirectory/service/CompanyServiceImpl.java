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

import com.ahmedbouchriha.peopledirectory.domain.Company;
import com.ahmedbouchriha.peopledirectory.repository.CompanyRepository;
import com.ahmedbouchriha.peopledirectory.service.exception.CompanyAlreadyExistsException;

@Service
@Validated
public class CompanyServiceImpl implements CompanyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);
	private final CompanyRepository repository;

	@Inject
	public CompanyServiceImpl(final CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Company save(@NotNull @Valid final Company company) {
		LOGGER.debug("Creating {}", company);
		System.out.println(company.getName());
		Company existing = repository.findOne(company.getId());
		if (existing != null) {
			throw new CompanyAlreadyExistsException(String.format("There already exists a Company with id=%s", company.getId()));
		}
		return repository.save(company);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> getList() {
		LOGGER.debug("Retrieving the list of all Companys");
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteCompany(Company Company) {
		repository.delete(Company);
	}

	@Override
	@Transactional
	public Company findCompanyById(Long id) {
		return repository.findOne(id);
	}

	/*@Override
	@Transactional
	public void updateCompany(Company Company) {
		repository.save(Company);
	}*/

}
