package com.ahmedbouchriha.peopledirectory.service;

import java.util.List;

import com.ahmedbouchriha.peopledirectory.domain.Company;

public interface CompanyService {

	Company save(Company Company);

	List<Company> getList();

	void deleteCompany(Company Company);

	Company findCompanyById(Long id);

	//void updateCompany(Company u);
}
