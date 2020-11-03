package com.blog.demo.application.nio;

import java.nio.ByteBuffer;

/*
 * https://blog.csdn.net/chennai1101/article/details/84957305
 */
public class BufferOperation {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		buffer.put((byte)0);
		buffer.put((byte)1);
		
		byte[] src = new byte[] {2, 3, 4};
		buffer.put(src);
		BufferTool.printBuffer(buffer);
		
		buffer.flip();
		System.out.println("after flip");
		BufferTool.printBuffer(buffer);
		
		System.out.println("get = " + buffer.get());
		BufferTool.printBuffer(buffer);
		
		byte[] dst = new byte[2];
		buffer.get(dst);
		System.out.println(dst[0] + ":" + dst[1]);
		BufferTool.printBuffer(buffer);
	}

}
