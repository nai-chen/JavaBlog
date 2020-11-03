package com.blog.demo.design.decorate;

public class DistilledWater extends CocktailDecorate {

	public DistilledWater(Cocktail decorate) {
		super(decorate);
	}

	@Override
	public String getDescription() {	
		return super.getDescription() + ", Distilled Water";
	}
	
}
