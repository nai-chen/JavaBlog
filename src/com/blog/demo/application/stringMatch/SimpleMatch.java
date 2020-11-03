package com.blog.demo.application.stringMatch;

/*
 * https://blog.csdn.net/chennai1101/article/details/84249861
 */
public class SimpleMatch extends AbstractMatch {

	public SimpleMatch(String pattern) {
		super(pattern);
	}

	public int match(String text) {
		for (int position = 0;
				position + pattern.length() <= text.length();
				position++) {
			if (matchAtPosition(text, position)) {
				return position;
			}
		}
		return -1;
	}
	
}
