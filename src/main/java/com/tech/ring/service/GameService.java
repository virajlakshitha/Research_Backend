package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.Game;
import com.tech.ring.request.GameRequest;

public interface GameService {

	public HashMap<String, String> createNewGame(GameRequest gameRequest);
	public List<Game> getAllGames();
	public Game getGameByName(String key);
	public Game findById(String id);
}
