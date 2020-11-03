package com.blog.demo.design.composite;

public class MenuItem extends Menu {
	
	public MenuItem(String name) {
		super(name);
	}
	
	public void addMenu(Menu menu) {
		System.out.println("Unsupport method addMenu");
	}
	
}
