package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Color;

public interface ColorService {
	public List<Color> getAllColors();
	
	public Color getColorById(Integer id);
}
