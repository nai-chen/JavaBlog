package com.blog.demo.design.decorate;

public class IceBlock extends CocktailDecorate {

	public IceBlock(Cocktail decorate) {
		super(decorate);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", Ice Block";
	}
	
}
