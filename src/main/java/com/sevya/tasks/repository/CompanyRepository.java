package com.sevya.tasks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sevya.tasks.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	@Query("FROM Company company where company.id = :companyId")
	public Company getCompanyById(@Param("companyId") Integer companyId);
	
}
