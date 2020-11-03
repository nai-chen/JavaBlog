package com.blog.demo.design.abstractfactory;

public class HankookFactory implements TyreFactory {

	@Override
	public Tyre createTyre() {
		return new Hankook();
	}

}
