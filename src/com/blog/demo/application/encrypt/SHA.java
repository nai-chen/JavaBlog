package com.blog.demo.application.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/*
 * https://blog.csdn.net/chennai1101/article/details/84553049
 */
public class SHA {
	
	public static void main(String[] args) {
		SHA.encrypt("SHA-1", ByteTool.TestStr);
		SHA.encrypt("SHA-256", ByteTool.TestStr);
	}
	
	public static void encrypt(String algorithm, String value) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(value.getBytes());
			System.out.println(algorithm + ":" + DatatypeConverter.printHexBinary(md.digest()));
		} catch (NoSuchAlgorithmException e) {
		}
	}
}
