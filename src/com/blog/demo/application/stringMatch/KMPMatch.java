package com.blog.demo.application.stringMatch;

/*
 * https://blog.csdn.net/chennai1101/article/details/84249861
 */
public class KMPMatch extends AbstractMatch {

	private int[] prefixArray;
	
	public KMPMatch(String pattern) {
		super(pattern);
		
		prefixArray = new int[pattern.length()];
		prefixArray[0] = -1;
		
		int matches = -1;
		int index = 0;
		
		while (index < pattern.length() - 1) {
			if (matches == -1 || pattern.charAt(index) == pattern.charAt(matches)) {
				++matches;
				++index;
				prefixArray[index] = matches;
			} else {
				matches = prefixArray[matches];
			}
		}
		
		for (index = 0; index <pattern.length(); index++) {
			System.out.println(prefixArray[index]);
		}
	}

	@Override
	public int match(String text) {
		int index = 0;
		int matches = 0;
		
		while (index < text.length() && matches < pattern.length()) {
			if (matches == - 1 || text.charAt(index) == pattern.charAt(matches)) {
				index++;
				matches++;
			} else {
				matches = prefixArray[matches];
			}
		}
		if (matches == pattern.length()) {
			return index - matches;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
//		new KMPMatch("abdabcd");
		System.out.println(new KMPMatch("abdabcd").match("abcabdabdabcd"));
	}

}
