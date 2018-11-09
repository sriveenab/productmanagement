package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Company;

public interface CompanyService {
	public List<Company> getAllCompanies();
	
	public Company getCompanyById(Integer id);
}
