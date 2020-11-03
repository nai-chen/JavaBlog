package com.blog.demo.application.nio;

import java.nio.ByteBuffer;

/*
 * https://blog.csdn.net/chennai1101/article/details/84957305
 */
public class BufferNew {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		for (int index = 0; index < 10; index++) {
			buffer.put((byte) index);
		}
		buffer.flip();
		BufferTool.printByteBuffer(buffer);
		
		ByteBuffer duplicateBuffer = buffer.duplicate();
		duplicateBuffer.put(0, (byte) 10);		
		BufferTool.printByteBuffer(buffer);		
		
		buffer.position(3);
		buffer.limit(6);
		ByteBuffer sliceBuffer = buffer.slice();
		BufferTool.printByteBuffer(sliceBuffer);
		
		sliceBuffer.put(0, (byte) 30);
		buffer.limit(10);
		BufferTool.printByteBuffer(buffer);
	}

}
