/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp;

import com.ducpq.demo.myspringbootapp.game.Game;
import com.ducpq.demo.myspringbootapp.game.GameRunner;
import com.ducpq.demo.myspringbootapp.game.PacmanGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyspringbootappApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyspringbootappApplication.class, args);
		
		
		Game game = new PacmanGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}
	
}
