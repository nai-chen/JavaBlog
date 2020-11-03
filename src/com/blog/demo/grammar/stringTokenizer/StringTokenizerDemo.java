package com.blog.demo.grammar.stringTokenizer;

import java.util.StringTokenizer;

/*
 * https://blog.csdn.net/chennai1101/article/details/84250541
 */
public class StringTokenizerDemo {
	
	public static void main(String[] args) {
		String str = "You can combine command line options and options from configuration files";
		StringTokenizer st = new StringTokenizer(str); 
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
//		
//		st = new StringTokenizer(str);
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken("ab"));
//		}
		
	}
	
}
