package com.blog.demo.grammar.variable;

/*
 * https://blog.csdn.net/chennai1101/article/details/84983515
 */
public class VariableDemo {

	public static void main(String[] args) {
		print(1);
		print(1, 2);
		print(1, 2, 3, 4, 5);
	}
	
	public static void print(int...args) {
		for (int value : args) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
//	public static void print(int...args, int value) {
//		
//	}

//	public static void print(int value, int...args) {
//		System.out.println("in print(int, int...)");
//	}
	
	public static void print(int value) {
		System.out.println("in print(int)");
	}

	public static void print(int value1, int value2) {
		System.out.println("in print(int, int)");
	}
	
}
