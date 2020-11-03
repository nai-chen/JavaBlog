package com.blog.demo.application.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * https://blog.csdn.net/chennai1101/article/details/84957305
 */
public class FileBuffer {
	
	public static void main(String[] args) {
		String fileInput = "D:\\121.jpg";
		String fileOutput = "D:\\122.jpg";
		
		new FileBuffer().copyFile(fileInput, fileOutput);
	}
	
	public void copyFile(String fileInput, String fileOutput) {
		try {
			FileInputStream input = new FileInputStream(fileInput);
			FileOutputStream output = new FileOutputStream(fileOutput);
			
			FileChannel inputChannel = input.getChannel();
			FileChannel outputChannel = output.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);			
			while(inputChannel.read(buffer) != -1) {
				buffer.flip();				
				outputChannel.write(buffer);				
				buffer.clear();
			}
			
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
