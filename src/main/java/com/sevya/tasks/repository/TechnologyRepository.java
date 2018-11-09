package com.sevya.tasks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Technology;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Integer>{
	
	@Query("FROM Technology technology where technology.id =:id")
	public Technology findOneById(@Param("id") Integer id);
	
	
}
