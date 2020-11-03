package com.blog.demo.design.facade;

public class People {

	public void gotoWork() {
		System.out.println("People goto work");
		new Bicycle().run(10);
		new Bus().run(40);
		new Walk().run(5);
	}
		
	public static void main(String[] args) {
		People people = new People();
		people.gotoWork();		
	}
	
}
