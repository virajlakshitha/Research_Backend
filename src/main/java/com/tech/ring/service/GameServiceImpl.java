package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Game;
import com.tech.ring.domain.Laptop;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.GameDao;
import com.tech.ring.request.GameRequest;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameDao gameDao;
	
	@Override
	public HashMap<String, String> createNewGame(GameRequest gameRequest) {

		Game game = gameDao.findByGameName(gameRequest.getName());
		
		if(game == null) {
			
				Game newGame = new Game();
				newGame.setName(gameRequest.getName());
				newGame.setCpu(gameRequest.getCpu());
				newGame.setRam(gameRequest.getRam());
				newGame.setGraphics(gameRequest.getGraphics()); 
				newGame.setStorage(gameRequest.getStorage());
				newGame.setImageSource(gameRequest.getImageSource());
				
				Game result = gameDao.SaveGame(newGame);
				
				if(result != null) {
					HashMap<String, String> hm = new HashMap<>();
					
					hm.put("Message", "Game succesfully Saved");
					return hm;
				}
				
				else {
					throw new TechRingException(TechRingApplicationErrors.GAME_ALLREADY_EXISTS);
				}
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_ALLREADY_EXISTS);
		}
	}

	@Override
	public List<Game> getAllGames() {

		List<Game> games = gameDao.findAllGames();
		
		if(games != null && !games.isEmpty()) {
			return games;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Game getGameByName(String key) {
		
		Game game = gameDao.findByGameName(key);
		
		if(game != null) {
			return game;
		}
		else {
			Game game1 = new Game();
			game1.setName("Not_found_game");
			return game1;
		}
		
	}

	@Override
	public Game findById(String id) {
		Game game = gameDao.findById(id);
		
		if(game != null) {
			
			return game;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.CAN_NOT_FIND_MATCHING_RESULT);
		}
	}

}
