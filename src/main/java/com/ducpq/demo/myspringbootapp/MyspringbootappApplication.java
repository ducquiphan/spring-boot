/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp;

import com.ducpq.demo.myspringbootapp.game.Game;
import com.ducpq.demo.myspringbootapp.game.GameRunner;
import com.ducpq.demo.myspringbootapp.game.SupperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyspringbootappApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyspringbootappApplication.class, args);
		//		Game game = new MarioGame();
		Game game = new SupperContraGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}
	
}
