package com.blog.demo.design.factorymethod;

public class Santana extends Car {

	public Santana() {
		super("Santana");
	}
	
	@Override
	public Tyre createTyre() {
		return new Hankook();
	}

}
