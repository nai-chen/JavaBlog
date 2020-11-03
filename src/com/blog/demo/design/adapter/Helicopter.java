package com.blog.demo.design.adapter;

public class Helicopter {
	
	public void flight() {
		System.out.println("Helicopter can flight");
	}
	
	public static void main(String[] args) {
		Bird bird = new Sparrow();
		bird.fly();
		
		bird = new Adapter(new Helicopter());
		bird.fly();
	}
  
}
