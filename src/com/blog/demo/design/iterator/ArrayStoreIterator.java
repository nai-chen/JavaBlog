package com.blog.demo.design.iterator;

public class ArrayStoreIterator implements Iterator {
	
	private String[] goodsArray;
	private int count;
	private int index;
	
	ArrayStoreIterator(String[] goodsArray, int count) {
		this.goodsArray = goodsArray;
		this.count = count;
		index = -1;
	}

	@Override
	public boolean haseNext() {
		return index + 1 < count;
	}

	@Override
	public Object next() {
		index = index + 1;
		return goodsArray[index];
	}

}
