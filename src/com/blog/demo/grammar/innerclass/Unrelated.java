package com.blog.demo.grammar.innerclass;

/*
 * https://blog.csdn.net/chennai1101/article/details/84233647
 */
public class Unrelated extends Super.Inner {
	
	public Unrelated(Super sup) {
		sup.super();
	}
	
	public static void main(String[] args) {
		Unrelated unrelated = new Unrelated(new Super());
		unrelated.print();
	}
	
}
