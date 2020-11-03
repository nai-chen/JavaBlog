package com.blog.demo.design.factorymethod;

public class Lavida extends Car {
	
	public Lavida() {
		super("Lavida");
	}

	@Override
	public Tyre createTyre() {
		return new Bridgestone();
	}

}
