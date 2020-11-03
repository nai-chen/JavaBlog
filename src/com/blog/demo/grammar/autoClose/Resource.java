package com.blog.demo.grammar.autoClose;

import java.io.IOException;

/*
 * https://blog.csdn.net/chennai1101/article/details/84987217
 */
public class Resource implements AutoCloseable {

	public void open(int value) throws IOException {
		if (value == 1) {
			throw new IOException();
		}
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Auto close");
	}
	
	public static void main(String[] args) {
		try (Resource resource = new Resource()) {
			resource.open(0);
		} catch (IOException e) {
			System.out.println("catch IOException");
		}
		
//		try (Resource resource = new Resource()) {
//			resource.open(1);
//		} catch (IOException e) {
//			System.out.println("catch IOException");
//		}
	}

}
