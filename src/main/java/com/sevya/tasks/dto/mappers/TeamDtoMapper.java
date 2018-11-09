package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.PlayerDto;
import com.sevya.tasks.dto.TeamDto;
import com.sevya.tasks.model.Team;

public class TeamDtoMapper {

	public static List<TeamDto> toTeamDtos(Team team, List<PlayerDto> playersDtos ) {
		List<TeamDto> teamDtos = new ArrayList<>();
		teamDtos.add(toTeamDto(team, playersDtos));
		return teamDtos;
	}
	
	public static TeamDto toTeamDto(Team team, List<PlayerDto> playerDtos) {
		TeamDto teamDto = new TeamDto();
		teamDto.setId(team.getId());
		teamDto.setTeamName(team.getTeamName());
		teamDto.setPlayers(playerDtos);
		return teamDto;
	}
	
	public static TeamDto toTeamDto(Team team) {
		TeamDto teamDto = new TeamDto();
		teamDto.setId(team.getId());
		teamDto.setTeamName(team.getTeamName());
		return teamDto;
	}
}
