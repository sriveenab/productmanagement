package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.PlayerDto;
import com.sevya.tasks.model.Player;

public class PlayerDtoMapper {

	public static List<PlayerDto> toPlayerDtos(List<Player> players) {

		List<PlayerDto> playerDtos = new ArrayList<>();
		for (Player player : players) {
			playerDtos.add(toPlayerDto(player));
		}
		return playerDtos;
	}

	public static PlayerDto toPlayerDto(Player player) {
		
		PlayerDto playerDto = new PlayerDto();
		playerDto.setCaptain(player.isCaptain());
		playerDto.setId(player.getId());
		playerDto.setPlayerName(player.getPlayerName());
		return playerDto;
	}

}
