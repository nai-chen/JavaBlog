package com.blog.demo.application.uri;

import java.net.URI;
import java.net.URISyntaxException;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783726
 */
public class URINetwork {
	public static void main(String[] args) throws URISyntaxException {
		String[] address = new String[]{
				"http://user:pwd@www.abc.com:8080/a/b/c?q=java#fragment",
				"tel:+123-4567-8910#frag"
		};
		
		for (String addr : address) {
			URI uri = new URI(addr);
			
			System.out.println("URI:        " + uri);
			System.out.println("Scheme:     " + uri.getScheme());
			if (uri.isOpaque()) {
				System.out.println("Specific:   " + uri.getSchemeSpecificPart());
			} else {
				System.out.println("UserInfo:   " + uri.getUserInfo());
				System.out.println("Authority:  " + uri.getAuthority());
				System.out.println("Host:       " + uri.getHost());
				System.out.println("Port:       " + uri.getPort());
				System.out.println("Path:       " + uri.getPath());
				System.out.println("Query:      " + uri.getQuery());
			}
			System.out.println("Fragment:   " + uri.getFragment());
			System.out.println();
		}
	}
}
