package com.sevya.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Player;
import com.sevya.tasks.repository.PlayerRepository;
import com.sevya.tasks.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	public PlayerRepository playerRepository;
	
	@Override
	public List<Player> getPlayersByTeamId(Integer teamId) {
		// TODO Auto-generated method stub
		List<Player> players = playerRepository.getPlayersByTeamId(teamId);
		return players;
	}

	@Override
	public Player getCaptainNameByTeamId(Integer teamId) {
		// TODO Auto-generated method stub
		Player player = playerRepository.getCaptainNameByTeamId(teamId);
		
		return player;
	}
	
	

}
