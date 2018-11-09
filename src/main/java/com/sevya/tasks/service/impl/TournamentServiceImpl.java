package com.sevya.tasks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Tournament;
import com.sevya.tasks.repository.TournamentRepository;
import com.sevya.tasks.service.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	public TournamentRepository tournamentRepository;
	
	@Override
	public Tournament saveTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		
		return tournamentRepository.save(tournament);
	}

}
