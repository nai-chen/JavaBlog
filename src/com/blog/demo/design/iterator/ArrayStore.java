package com.blog.demo.design.iterator;

public class ArrayStore {

	private String[] goodsArray;
	private int count;
	
	public ArrayStore() {
		goodsArray = new String[100];
		count = 0;
	}
	
	public void addGoods(String goods) {
		goodsArray[count] = goods;
		++count;
	}
	
	public Iterator iterator() {
		return new ArrayStoreIterator(goodsArray, count);
	}
	
}
