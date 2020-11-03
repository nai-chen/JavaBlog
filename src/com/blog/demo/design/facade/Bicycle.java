package com.blog.demo.design.facade;

public class Bicycle implements Traffic {

	@Override
	public void run(int minute) {
		System.out.println("Take " + minute + " minute by Bicycle");
	}

}
