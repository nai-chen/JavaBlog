package com.blog.demo.design.adapter;

public class Adapter implements Bird {

	private Helicopter helicopter;
	
	public Adapter(Helicopter helicopter) {
		this.helicopter = helicopter;
	}
	
	@Override
	public void fly() {
		this.helicopter.flight();
	}
	
}
