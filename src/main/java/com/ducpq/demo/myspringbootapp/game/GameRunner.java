/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp.game;

/**
 * GameRunner
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-20
 */
public class GameRunner {
	
	//	private final MarioGame game;
	private final Game game;
	
	//	public GameRunner(MarioGame game) {
	//		this.game = game;
	//	}
	
	public GameRunner(Game game) {
		this.game = game;
	}
	
	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
