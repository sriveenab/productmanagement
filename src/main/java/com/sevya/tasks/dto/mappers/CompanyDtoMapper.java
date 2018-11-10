package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.ColorDto;
import com.sevya.tasks.dto.CompanyDto;
import com.sevya.tasks.model.Color;
import com.sevya.tasks.model.Company;

public class CompanyDtoMapper {
	public static List<CompanyDto> toCompanyDtos(List<Company> companies) {
		
		List<CompanyDto> companyDtos = new ArrayList<>();
		for(Company company : companies) {
			companyDtos.add(toCompanyDto(company));
		}
		return companyDtos;
	}
	
	public static CompanyDto toCompanyDto(Company company) {
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		return companyDto;
	}
	
	public static Company toComapny(CompanyDto companyDto) {
		Company company = new Company();
		company.setId(companyDto.getId());
		company.setName(companyDto.getName());
		return company;
	}
}
