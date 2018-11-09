package com.sevya.tasks.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tournament")
public class Tournament extends BaseModel {

	private Date dateOfTournament;

	@OneToOne(targetEntity = Team.class)
	@JoinColumn(name = "teamAId")
	private Team teamA;

	@OneToOne(targetEntity = Team.class)
	@JoinColumn(name = "teamBId")
	private Team teamB;

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public Date getDateOfTournament() {
		return dateOfTournament;
	}

	public void setDateOfTournament(Date dateOfTournament) {
		this.dateOfTournament = dateOfTournament;
	}

}
