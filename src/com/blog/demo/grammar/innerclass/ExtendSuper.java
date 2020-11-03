package com.blog.demo.grammar.innerclass;

/*
 * https://blog.csdn.net/chennai1101/article/details/84233647
 */
public class ExtendSuper extends Super {
	Inner inner = new ExtendInner();
	
	public class ExtendInner extends Inner {
		
	}
	
}
