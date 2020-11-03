package com.blog.demo.design.decorate;

public class Test {

	public static void main(String[] args) {
		Cocktail cocktail = new Whisky();
		cocktail = new LemonJuice(cocktail);
		cocktail = new PomegranateJuice(cocktail);
		cocktail = new DistilledWater(cocktail);
		System.out.println(cocktail.getDescription());
		
		cocktail = new Vodka();
		cocktail = new IceBlock(cocktail);
		System.out.println(cocktail.getDescription());
	}

}
