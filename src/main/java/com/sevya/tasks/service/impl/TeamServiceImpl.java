package com.sevya.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Team;
import com.sevya.tasks.repository.TeamRepository;
import com.sevya.tasks.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	public TeamRepository teamRepository;

	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepository.getAllTeams();
	}

	@Override
	public Team getTeamById(Integer teamId) {
		// TODO Auto-generated method stubte
		Team team = teamRepository.getTeamById(teamId);
		return team;
	}

}
