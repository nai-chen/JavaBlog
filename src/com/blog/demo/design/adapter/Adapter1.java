package com.blog.demo.design.adapter;

public class Adapter1 extends Helicopter implements Bird {

	@Override
	public void fly() {		
		flight();
	}
}
