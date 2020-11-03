package com.blog.demo.design.composite;

import java.util.ArrayList;
import java.util.List;

public class MenuComposite extends Menu {
	private List<Menu> menuList = new ArrayList<>();

	public MenuComposite(String name) {
		super(name);
	}
	
	@Override
	public void addMenu(Menu menu) {	
		menuList.add(menu);
	}
	
	@Override
	public void print(int indent) {	
		super.print(indent);
		
		for (Menu menu : menuList) {
			menu.print(indent + 1);
		}
	}

}
