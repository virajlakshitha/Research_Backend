package com.tech.ring.repository;

import java.util.List;
import com.tech.ring.domain.Game;

public interface GameDao {
	
	public Game findByGameName(String gameName);
	public Game SaveGame(Game newGame);
	public List<Game> findAllGames();
}
