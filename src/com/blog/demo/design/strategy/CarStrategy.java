package com.blog.demo.design.strategy;

public class CarStrategy implements TrafficStrategy {

	@Override
	public void run() {
		System.out.println("buy car");
	}

}
