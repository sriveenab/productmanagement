package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Player;

public interface PlayerService {

	public List<Player> getPlayersByTeamId(Integer teamId);
	
	public Player getCaptainNameByTeamId(Integer teamId);
	
}
