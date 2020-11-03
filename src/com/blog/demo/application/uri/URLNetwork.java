package com.blog.demo.application.uri;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783726
 */
public class URLNetwork {
	public static void main(String[] args) throws MalformedURLException {
		String[] address = new String[]{
				"http://user:pwd@www.abc.com:80/a/b/c?q=java#fragment",
				"ftp://www.abc.com:8080/"
		};
		
		for (String addr : address) {
			URL url = new URL(addr);
			
			System.out.println("URL:        " + url);
			System.out.println("Protocol:   " + url.getProtocol());
			System.out.println("UserInfo:   " + url.getUserInfo());
			System.out.println("Authority:  " + url.getAuthority());
			System.out.println("Host:       " + url.getHost());
			System.out.println("Port:       " + url.getPort());
			System.out.println("DefaultPort:" + url.getDefaultPort());
			System.out.println("Path:       " + url.getPath());
			System.out.println("File:       " + url.getFile());
			System.out.println("Query:      " + url.getQuery());
			System.out.println("Ref:        " + url.getRef());
			System.out.println();
		}
	}
}
