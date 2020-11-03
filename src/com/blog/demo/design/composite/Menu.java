package com.blog.demo.design.composite;

public abstract class Menu {
	private String name;
	
	public Menu(String name) {
		this.name = name;
	}

	public abstract void addMenu(Menu menu);
	
	public void print() {
		print(0);
	}

	public void print(int indent) {
		for (int index = 0; index < indent; index++) {
			System.out.print("#");
		}
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		Menu fileMenu = new MenuComposite("File");
		
		Menu newMenuItem = new MenuItem("New");
		fileMenu.addMenu(newMenuItem);
		
		Menu openMenu = new MenuComposite("Open");
		fileMenu.addMenu(openMenu);
		
		Menu openFileMenuItem = new MenuItem("Open File");
		openMenu.addMenu(openFileMenuItem);
		
		Menu openDirectoryMenuItem = new MenuItem("Open Directory");
		openMenu.addMenu(openDirectoryMenuItem);
		
		fileMenu.print();
	}
	
}
