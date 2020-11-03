package com.blog.demo.application.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderNetwork {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println(URLEncoder.encode("@#$%^&*","UTF-8"));
//		System.out.println(URLDecoder.decode("%40%23%24%25%5E%26*", "UTF-8"));
		
		System.out.println(URLEncoder.encode("value1=123&valu2=pwd", "UTF-8"));
		System.out.println(URLDecoder.decode("value1%3D123%26valu2%3Dpwd", "UTF-8"));
	}
	
}
