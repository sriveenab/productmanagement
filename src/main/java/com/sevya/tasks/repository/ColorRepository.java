package com.sevya.tasks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color, Integer> {
	
	@Query("FROM Color color where color.id = :colorId")
	public Color getColorById(@Param("colorId") Integer colorId);
	
}
