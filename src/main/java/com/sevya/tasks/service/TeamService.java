package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Team;

public interface TeamService {
	
	public List<Team> getAllTeams();
	
	public Team getTeamById(Integer teamId);
}