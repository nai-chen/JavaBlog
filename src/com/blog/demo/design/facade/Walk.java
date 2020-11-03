package com.blog.demo.design.facade;

public class Walk implements Traffic {

	@Override
	public void run(int minute) {
		System.out.println("Take " + minute + " minute by Walk");
	}

}
