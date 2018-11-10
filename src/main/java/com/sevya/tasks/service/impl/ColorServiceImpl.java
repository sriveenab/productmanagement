package com.sevya.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Color;
import com.sevya.tasks.repository.ColorRepository;
import com.sevya.tasks.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	public ColorRepository colorRepository;
	
	@Override
	public List<Color> getAllColors() {
		// TODO Auto-generated method stub
		List<Color> colors = new ArrayList<>();
		for(Color color : colorRepository.findAll()) {
			colors.add(color);
		}
		return colors;
	}

	@Override
	public Color getColorById(Integer id) {
		// TODO Auto-generated method stub
		Color color = colorRepository.getColorById(id);
		return color;
	}

}
