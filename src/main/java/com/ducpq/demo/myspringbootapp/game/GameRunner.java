/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * GameRunner
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-20
 */
@Component
public class GameRunner {
	
	@Qualifier("pacmanGame")
	private final Game game;
	
	//	public GameRunner(MarioGame game) {
	//		this.game = game;
	//	}
	
	public GameRunner(@Qualifier("pacmanGame") Game game) {
		this.game = game;
	}
	
	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
