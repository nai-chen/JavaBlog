package com.blog.demo.design.factorymethod;

public class Lamando extends Car {
	
	public Lamando() {
		super("Lamando");
	}

	@Override
	public Tyre createTyre() {
		return new Michelin();
	}

}
