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

import org.springframework.stereotype.Component;

@Component
public class SupperContraGame implements Game {
	@Override
	public void up() {
		System.out.println("SupperContra up");
	}
	
	@Override
	public void down() {
		System.out.println("SupperContra down");
	}
	
	@Override
	public void left() {
		System.out.println("SupperContra left");
	}
	
	@Override
	public void right() {
		System.out.println("SupperContra right");
	}
}
