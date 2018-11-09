package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	@Query("FROM Player player LEFT JOIN FETCH player.team as team where team.id = :teamId")
	public List<Player> getPlayersByTeamId(@Param("teamId") Integer teamId);
	
	
	@Query("FROM Player player LEFT JOIN FETCH player.team as team where team.id = :teamId and player.isCaptain=1")
	public Player getCaptainNameByTeamId(@Param("teamId") Integer teamId);
	
}
