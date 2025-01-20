/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp;

import com.ducpq.demo.myspringbootapp.game.GameRunner;
import com.ducpq.demo.myspringbootapp.game.SupperContraGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyspringbootappApplication {
	
	public static void main(String[] args) {
		//		SpringApplication.run(MyspringbootappApplication.class, args);
		//		MarioGame game = new MarioGame();
		SupperContraGame game = new SupperContraGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}
	
}
