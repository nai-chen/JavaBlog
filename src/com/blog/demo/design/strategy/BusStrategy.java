package com.blog.demo.design.strategy;

public class BusStrategy implements TrafficStrategy {

	@Override
	public void run() {
		System.out.println("buy bus");
	}

}
