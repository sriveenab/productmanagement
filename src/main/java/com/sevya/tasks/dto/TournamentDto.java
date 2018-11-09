package com.sevya.tasks.dto;

public class TournamentDto {

	private String dateOfTournament;
	private String teamACaptain;
	private String teamBCaptain;

	private TeamDto teamA;
	private TeamDto teamB;

	public String getTeamACaptain() {
		return teamACaptain;
	}

	public void setTeamACaptain(String teamACaptain) {
		this.teamACaptain = teamACaptain;
	}

	public String getTeamBCaptain() {
		return teamBCaptain;
	}

	public void setTeamBCaptain(String teamBCaptain) {
		this.teamBCaptain = teamBCaptain;
	}

	public String getDateOfTournament() {
		return dateOfTournament;
	}

	public void setDateOfTournament(String dateOfTournament) {
		this.dateOfTournament = dateOfTournament;
	}

	public TeamDto getTeamA() {
		return teamA;
	}

	public void setTeamA(TeamDto teamA) {
		this.teamA = teamA;
	}

	public TeamDto getTeamB() {
		return teamB;
	}

	public void setTeamB(TeamDto teamB) {
		this.teamB = teamB;
	}

}
