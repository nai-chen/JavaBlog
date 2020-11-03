package com.blog.demo.grammar.override;

/*
 * https://blog.csdn.net/chennai1101/article/details/84287021
 */
public class Sub extends Sup {
	public int value = 2;
	public static int staticValue = 20;
	
	@Override
	public int getValue() {
		return value;
	}
	
	public static int getStaticValue() {
		return staticValue;
	}
	
	public static void main(String[] args) {
		Sup sup = new Sub();
		Sub sub = new Sub();
		
		System.out.println("sup.value = " + sup.value);
		System.out.println("sup.staticValue = " + sup.staticValue);
		System.out.println("sup.getValue() = " + sup.getValue());
		System.out.println("sup.getStaticValue() = " + sup.getStaticValue());
		
		System.out.println("sub.value = " + sub.value);
		System.out.println("sub.staticValue = " + sub.staticValue);
		System.out.println("sub.getValue() = " + sub.getValue());
		System.out.println("sub.getStaticValue() = " + sub.getStaticValue());
	}
	
}
