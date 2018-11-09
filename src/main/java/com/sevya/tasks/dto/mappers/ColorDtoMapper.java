package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.ColorDto;
import com.sevya.tasks.model.Color;

public class ColorDtoMapper {
	public static List<ColorDto> toColorDtos(List<Color> colors) {
		
		List<ColorDto> colorDtos = new ArrayList<>();
		for(Color color : colors) {
			colorDtos.add(toColorDto(color));
		}
		return colorDtos;
	}
	
	public static ColorDto toColorDto(Color color) {
		ColorDto colorDto = new ColorDto();
		colorDto.setId(color.getId());
		colorDto.setName(color.getName());
		return colorDto;
	}
	
	public static Color toColor(ColorDto colorDto) {
		Color color = new Color();
		color.setId(colorDto.getId());
		color.setName(colorDto.getName());
		return color;
	}
}
