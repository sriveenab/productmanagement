package com.sevya.tasks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player extends BaseModel {

	private String playerName;

	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId")
	private Team team;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean isCaptain = false;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
