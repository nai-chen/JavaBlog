package com.blog.demo.application.nio;

import java.nio.ByteBuffer;

/*
 * https://blog.csdn.net/chennai1101/article/details/84957305
 */
public class BufferConstructor {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		BufferTool.printBuffer(buffer);		
		
		byte[] byteArray = new byte[10];
		buffer = ByteBuffer.wrap(byteArray);
		BufferTool.printBuffer(buffer);
	}
	
}
