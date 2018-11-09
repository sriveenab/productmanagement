package com.sevya.tasks.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sevya.tasks.dto.BookDto;
import com.sevya.tasks.dto.TeamDto;
import com.sevya.tasks.dto.TechnologyDto;
import com.sevya.tasks.dto.TournamentDto;
import com.sevya.tasks.dto.mappers.BookDtoMapper;
import com.sevya.tasks.dto.mappers.PlayerDtoMapper;
import com.sevya.tasks.dto.mappers.TeamDtoMapper;
import com.sevya.tasks.dto.mappers.TechnologyDtoMapper;
import com.sevya.tasks.model.Book;
import com.sevya.tasks.model.Player;
import com.sevya.tasks.model.Team;
import com.sevya.tasks.model.Technology;
import com.sevya.tasks.model.Tournament;
import com.sevya.tasks.service.BookService;
import com.sevya.tasks.service.PlayerService;
import com.sevya.tasks.service.TeamService;
import com.sevya.tasks.service.TechnologyService;
import com.sevya.tasks.service.TournamentService;

@RestController
public class CricketController {

	@Autowired
	public TeamService teamService;

	@Autowired
	public PlayerService playerService;

	@Autowired
	public TournamentService tournamentService;

	

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<TeamDto> getTeams() {
		List<TeamDto> teamsDtos = new ArrayList<>();
		for (Team team : teamService.getAllTeams()) {
			List<Player> players = team.getPlayers();
			teamsDtos.add(TeamDtoMapper.toTeamDto(team, PlayerDtoMapper.toPlayerDtos(players)));
		}
		return teamsDtos;
	}

	@RequestMapping(value = "/tournament", method = RequestMethod.POST)
	public TournamentDto saveMatch(@RequestBody TournamentDto tournamentDto) throws ParseException {

		Tournament tournament = new Tournament();
		Team teamA = teamService.getTeamById(tournamentDto.getTeamA().getId());
		tournament.setTeamA(teamA);
		Team teamB = teamService.getTeamById(tournamentDto.getTeamB().getId());
		tournament.setTeamB(teamB);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date langDate = sdf.parse(tournamentDto.getDateOfTournament());
		tournament.setDateOfTournament(langDate);
		tournament = tournamentService.saveTournament(tournament);

		TournamentDto tournamentDtoObj = new TournamentDto();
		String dateStr = sdf.format(tournament.getDateOfTournament());
		tournamentDtoObj.setDateOfTournament(dateStr);
		tournamentDtoObj.setTeamA(TeamDtoMapper.toTeamDto(tournament.getTeamA()));
		tournamentDtoObj.setTeamB(TeamDtoMapper.toTeamDto(tournament.getTeamB()));
		Player teamACaptain = playerService.getCaptainNameByTeamId(tournamentDtoObj.getTeamA().getId());
		Player teamBCaptain = playerService.getCaptainNameByTeamId(tournamentDtoObj.getTeamB().getId());
		tournamentDtoObj.setTeamACaptain(teamACaptain.getPlayerName());
		tournamentDtoObj.setTeamBCaptain(teamBCaptain.getPlayerName());
		return tournamentDtoObj;

	}

	

}
