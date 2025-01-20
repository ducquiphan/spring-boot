/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.myspringbootapp.game;

/**
 * MarioGame
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-20
 */
public class PacmanGame implements Game {
	@Override
	public void up() {
		System.out.println("Pacman up");
	}
	
	@Override
	public void down() {
		System.out.println("Pacman down");
	}
	
	@Override
	public void left() {
		System.out.println("Pacman left");
	}
	
	@Override
	public void right() {
		System.out.println("Pacman right");
	}
}
