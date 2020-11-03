package com.blog.demo.application.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/*
 * https://blog.csdn.net/chennai1101/article/details/84553049
 */
public class MD5 {	
	
	public static void main(String[] args) {
		MD5.encrypt(ByteTool.TestStr);
	}
	
	public static void encrypt(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(value.getBytes());
			System.out.println("MD5:" + DatatypeConverter.printHexBinary(md.digest()));
		} catch (NoSuchAlgorithmException e) {			
		}
	}
	
}
