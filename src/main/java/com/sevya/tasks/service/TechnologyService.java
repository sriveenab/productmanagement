package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Technology;

public interface TechnologyService {

	public List<Technology> getAllTechnologies();
	
	public Technology getTechnologyById(Integer technologyId);
	
}
