package com.blog.demo.grammar.override;

/*
 * https://blog.csdn.net/chennai1101/article/details/84287021
 */
public class Sup {
	public int value = 1;
	public static int staticValue = 10;
	
	public int getValue() {
		return value;
	}
	
	public static int getStaticValue() {
		return staticValue;
	}
	
}
