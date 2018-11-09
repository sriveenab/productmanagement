package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

	@Query("FROM Team team")
	public List<Team> getAllTeams();
	
	@Query("FROM Team team where team.id = :teamId")
	public Team getTeamById(@Param("teamId") Integer teamId);
	
}
