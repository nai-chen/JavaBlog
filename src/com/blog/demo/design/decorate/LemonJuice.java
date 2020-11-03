package com.blog.demo.design.decorate;

public class LemonJuice extends CocktailDecorate {

	public LemonJuice(Cocktail decorate) {
		super(decorate);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", Lemon Juice";
	}
	
}
