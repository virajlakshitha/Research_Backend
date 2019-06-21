package com.tech.ring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Game;
import com.tech.ring.request.GameRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.GameService;

@RestController
@RequestMapping(value = "/api-techRing/games")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public TechRingResponse createGame(@RequestBody GameRequest gameRequest) {
		
		HashMap<String, String> game = gameService.createNewGame(gameRequest);
		
		TechRingResponse response = new TechRingResponse();
		response.setResponseCode("111");
		response.setResponseObject(game);
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	public TechRingResponse getAllGames() {
		
		List<Game> games = gameService.getAllGames();
		
		TechRingResponse response = new TechRingResponse();
		response.setResponseCode("111");
		response.setResponseObject(games);
		
		return response;
	}

}


