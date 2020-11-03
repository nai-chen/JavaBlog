package com.blog.demo.design.abstractfactory;

public class MichelinFactory implements TyreFactory {

	@Override
	public Tyre createTyre() {
		return new Michelin();
	}

}
