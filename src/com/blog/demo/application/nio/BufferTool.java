package com.blog.demo.application.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/*
 * https://blog.csdn.net/chennai1101/article/details/84957305
 */
public class BufferTool {
	public static void printBuffer(Buffer buffer) {
		System.out.println("position = " + buffer.position()
			+ ", capacity = " + buffer.capacity()
			+ ", limit = " + buffer.limit());
	}
	
	public static void printByteBuffer(ByteBuffer buffer) {
		System.out.print("[");	
		
		for (int index = 0; index < buffer.limit(); index++) {
			if (index != 0) {
				System.out.print(", ");	
			}
			System.out.print(buffer.get(index));
		}
			
		System.out.println("]");
	}
}
