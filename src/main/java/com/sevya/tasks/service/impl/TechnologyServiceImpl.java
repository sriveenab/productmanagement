package com.sevya.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Technology;
import com.sevya.tasks.repository.TechnologyRepository;
import com.sevya.tasks.service.TechnologyService;

@Service
public class TechnologyServiceImpl implements TechnologyService {
	
	@Autowired
	public TechnologyRepository technologyRepository;
	
	@Override
	public List<Technology> getAllTechnologies() {
		List<Technology> technologies = new ArrayList<>();
		for(Technology technology : technologyRepository.findAll()) {
			technologies.add(technology);
		}
		return technologies;
	}

	@Override
	public Technology getTechnologyById(Integer technologyId) {
		return technologyRepository.findOneById(technologyId);
	}


}
