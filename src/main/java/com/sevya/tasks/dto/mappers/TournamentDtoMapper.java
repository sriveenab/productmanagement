package com.sevya.tasks.dto.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sevya.tasks.dto.TournamentDto;
import com.sevya.tasks.model.Tournament;

public class TournamentDtoMapper {

	public static TournamentDto toTournamentDto(Tournament tournament) {
		TournamentDto tournamenDto = new TournamentDto();
		tournamenDto.setDateOfTournament(tournament.getDateOfTournament().toString());
		tournamenDto.setTeamA(TeamDtoMapper.toTeamDto(tournament.getTeamA()));
		tournamenDto.setTeamB(TeamDtoMapper.toTeamDto(tournament.getTeamB()));
		return tournamenDto;
	}
	
	public static Tournament toTournament(TournamentDto tournamentDto) throws ParseException {
		
		Tournament tournament = new Tournament();
		tournament.setCreatedDate(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date langDate = sdf.parse(tournamentDto.getDateOfTournament());
		tournament.setDateOfTournament(langDate);
		return tournament;
	}
	
}
