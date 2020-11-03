package com.blog.demo.design.abstractfactory;

public abstract class Car {
	
	String name;
	Tyre tyre;
	
	public Car(String name, TyreFactory factory) {
		this.name = name;
		tyre = factory.createTyre();
	}
	
	public void description() {
		System.out.println(name + " use " + tyre.getDescription());
	}
		
	public static void main(String[] args) {
		Car car = new Lamando(new MichelinFactory());
		car.description();
		
		car = new Lavida(new BridgestoneFactory());
		car.description();
		
		car = new Santana(new HankookFactory());
		car.description();
	}
	
}
