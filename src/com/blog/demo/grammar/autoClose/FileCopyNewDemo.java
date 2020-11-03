package com.blog.demo.grammar.autoClose;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * https://blog.csdn.net/chennai1101/article/details/84987217
 */
public class FileCopyNewDemo {
	public static void main(String[] args) {
		String fileInput = "D:\\121.jpg";
		String fileOutput = "D:\\122.jpg";
		
		new FileCopyNewDemo().copyFile(fileInput, fileOutput);
	}
	
	public void copyFile(String fileInput, String fileOutput) {		 
		try (InputStream input = new FileInputStream(fileInput);
				OutputStream output = new FileOutputStream(fileOutput)) {
			
			byte[] byteArray = new byte[1024];
			int len = 0;
			while((len = input.read(byteArray)) != -1) {
				output.write(byteArray, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
