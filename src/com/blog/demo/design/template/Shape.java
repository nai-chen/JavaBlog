package com.blog.demo.design.template;

public abstract class Shape {

	public void draw() {
		drawBackground();
		drawBound();
		drawShape();
	}
	
	public void drawBackground() {
		System.out.println("Shape drawBackground");
	}
	
	public void drawBound() {
		System.out.println("Shape drawBound");
	}
	
	public abstract void drawShape();	
	
	public static void main(String[] args) {
		Shape circle = new Circle();
		circle.draw();
		
		Shape oval = new Oval();
		oval.draw();
		
		Shape rectangle = new Rectangle();
		rectangle.draw();
	}
}
