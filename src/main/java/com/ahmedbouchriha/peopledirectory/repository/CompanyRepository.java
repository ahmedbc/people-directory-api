package com.ahmedbouchriha.peopledirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedbouchriha.peopledirectory.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
