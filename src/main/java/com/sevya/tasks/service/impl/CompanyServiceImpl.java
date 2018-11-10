package com.sevya.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Company;
import com.sevya.tasks.repository.CompanyRepository;
import com.sevya.tasks.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	public CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		List<Company> companies = new ArrayList<>();
		for(Company company : companyRepository.findAll()) {
			companies.add(company);
		}
		return companies;
	}

	@Override
	public Company getCompanyById(Integer id) {
		// TODO Auto-generated method stub
		Company company = companyRepository.getCompanyById(id);
		return company;
	}

}
