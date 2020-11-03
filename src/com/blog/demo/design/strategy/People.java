package com.blog.demo.design.strategy;

public class People {
	private String name;
	
	public People(String name) {
		this.name = name;
	}
	
	public void gotoWork(TrafficStrategy strategy) {
		System.out.print(name + " goto work ");
		strategy.run();
	}
	
	public static void main(String[] args) {
		People jack = new People("Jack");
		jack.gotoWork(new CarStrategy());
		
		People mike = new People("Mike");
		mike.gotoWork(new BusStrategy());
		
		People lily = new People("Lily");
		lily.gotoWork(new BicycleStrategy());
	}
	
}
