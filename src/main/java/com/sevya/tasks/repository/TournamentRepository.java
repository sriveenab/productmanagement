package com.sevya.tasks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Tournament;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Integer> {
	
	

}
