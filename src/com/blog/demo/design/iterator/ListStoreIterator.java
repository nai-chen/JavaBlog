package com.blog.demo.design.iterator;

import java.util.List;

public class ListStoreIterator implements Iterator {
	
	private List<String> goodsList;
	private int index;
	
	public ListStoreIterator(List<String> goodsList) {
		this.goodsList = goodsList;
		index = -1;
	}

	@Override
	public boolean haseNext() {
		return index + 1 < goodsList.size();
	}

	@Override
	public Object next() {
		index = index + 1;
		return goodsList.get(index);
	}

}
