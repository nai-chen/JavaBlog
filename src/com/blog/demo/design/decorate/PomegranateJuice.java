package com.blog.demo.design.decorate;

public class PomegranateJuice extends CocktailDecorate {

	public PomegranateJuice(Cocktail decorate) {
		super(decorate);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", Pomegranate Juice";
	}
	
}
