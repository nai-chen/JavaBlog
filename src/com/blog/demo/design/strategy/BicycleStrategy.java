package com.blog.demo.design.strategy;

public class BicycleStrategy implements TrafficStrategy {

	@Override
	public void run() {
		System.out.println("buy bicycle");
	}

}
