package com.blog.demo.application.stringMatch;

/*
 * https://blog.csdn.net/chennai1101/article/details/84249861
 */
public abstract class AbstractMatch {
	protected final String pattern;

	public AbstractMatch(String pattern) {
		this.pattern = pattern;
	}
	
	public abstract int match(String text);
	
	protected boolean matchAtPosition(String text, int position) {
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(position + i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String pattern = "abcd";
		StringBuffer sBuffer = new StringBuffer();
		
		for (int i = 0; i < 10000000; i++) {
			sBuffer.append("abc");
		}
		sBuffer.append("abcd");
		
		String text = sBuffer.toString();
		
		int count = 1;	
		
		match(new SimpleMatch(pattern), count, text);
		match(new KMPMatch(pattern), count, text);
		
	}
	
	private static void match(AbstractMatch match, int count, String text) {
		long timeMillis = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
//			System.out.println(match.match(text));
			match.match(text);
		}		
		System.out.println(System.currentTimeMillis() - timeMillis);
	}
	
}
