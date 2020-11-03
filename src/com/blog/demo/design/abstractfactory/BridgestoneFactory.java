package com.blog.demo.design.abstractfactory;

public class BridgestoneFactory implements TyreFactory {

	@Override
	public Tyre createTyre() {
		return new Bridgestone();
	}

}
