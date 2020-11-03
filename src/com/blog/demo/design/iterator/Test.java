package com.blog.demo.design.iterator;

public class Test {

	public static void main(String[] args) {
		ArrayStore arrayStore = new ArrayStore();
		arrayStore.addGoods("goods1");
		arrayStore.addGoods("goods2");
		arrayStore.addGoods("goods3");

		System.out.print("ArrayStore have");
		for (Iterator iterator = arrayStore.iterator(); iterator.haseNext();) {
			System.out.print(" " + iterator.next());
		}
		System.out.println();
		
		ListStore listStore = new ListStore();
		listStore.addGoods("goods4");
		listStore.addGoods("goods5");
		System.out.print("ListStore have");
		for (Iterator iterator = listStore.iterator(); iterator.haseNext();) {
			System.out.print(" " + iterator.next());
		}
		System.out.println();
	}

}
