/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.service.impl;

import com.ducpq.demo.aop.service.TrafficFortuneService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TrafficFortuneServiceImpl
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-26
 */
@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
	@Override
	public String getFortune() {
		// Simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		// return a fortune
		return "Expect heavy traffic this morning";
	}
	
	/**
	 * @param tripWire
	 * @return
	 */
	@Override
	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		return getFortune();
	}
}
