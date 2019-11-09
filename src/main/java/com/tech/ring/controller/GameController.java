package com.tech.ring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Game;
import com.tech.ring.domain.Laptop;
import com.tech.ring.repository.GameDao;
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
	
	@RequestMapping(method = RequestMethod.GET, value ="/{key}/getgame" )
	public TechRingResponse getGame(@PathVariable("key") String key) throws IOException, InterruptedException {
		
		TechRingResponse response = new TechRingResponse();
		Game game = gameService.getGameByName(key);
		System.out.println(game.getName() );
		
		if(game.getName().equals("Not_found_game")){
			String path = System.getProperty("user.home") + "/Desktop/REASERCH/Reasearh_Scripts/game_requirement/Game_sys_req_scrape.py"; 
	 
			//scrape the game details
			String[] cmd = {
				"python",
			     path,
			     key
			   };
			    Process p = Runtime.getRuntime().exec(cmd); 

		}

//		sleep 60s , search game and send if available the game
		Thread.sleep(60000);
		Game game1 = gameService.getGameByName(key);
		response.setResponseCode("111");
		response.setResponseObject(game1);
		
		return response; 
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/findById/{id}")
	public TechRingResponse findGameById(@PathVariable("id") String id) {
		
		Game game = gameService.findById(id);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(game);
		
		return techRingResponse;
	}
 
}

 




