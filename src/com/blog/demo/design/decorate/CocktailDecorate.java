package com.blog.demo.design.decorate;

public abstract class CocktailDecorate implements Cocktail {
	Cocktail cocktail;
	
	public CocktailDecorate(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	@Override
	public String getDescription() {
		return cocktail.getDescription();
	}

}
