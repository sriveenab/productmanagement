package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.TechnologyDto;
import com.sevya.tasks.model.Technology;

public class TechnologyDtoMapper {
	
	public static List<TechnologyDto> toTechnologyDtos(List<Technology> technologies) {
		
		List<TechnologyDto> technologyDtos = new ArrayList<TechnologyDto>();
		for(Technology technology : technologies) {
			technologies.add(technology);
		}
		return technologyDtos;
	}
	
	public static TechnologyDto toTechnologyDto(Technology technology) {
		
		TechnologyDto technologyDto = new TechnologyDto();
		technologyDto.setName(technology.getTechnologyName());
		technologyDto.setId(technology.getId());
		return technologyDto;
	}
	
}
