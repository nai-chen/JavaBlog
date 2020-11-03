package com.blog.demo.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class ListStore {
	private List<String> goodsList = new ArrayList<>();
	
	public void addGoods(String goods) {
		goodsList.add(goods);
	}
	
	public Iterator iterator() {
		return new ListStoreIterator(goodsList);
	}
	
}
