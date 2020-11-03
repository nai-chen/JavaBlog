package com.blog.demo.design.factorymethod;

public abstract class Car {
	
	String name;
	Tyre tyre;
	
	public Car(String name) {
		this.name = name;
		tyre = createTyre();
	}
	
	public abstract Tyre createTyre();
	
	public void description() {
		System.out.println(name + " use " + tyre.getDescription());
	}
		
	public static void main(String[] args) {
		Car car = new Lamando();
		car.description();
		
		car = new Lavida();
		car.description();
		
		car = new Santana();
		car.description();
	}
	
}
