package com.blog.demo.application.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783768
 */
public class InetAddressDemo {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostName() + "/" + addr.getHostAddress());
		
		addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName() + "/" + addr.getHostAddress());
		
		addr = InetAddress.getByName("115.239.211.112");
		System.out.println(addr.getCanonicalHostName() + "/" + addr.getHostAddress());
		
		addr.isAnyLocalAddress();
		addr.isLoopbackAddress();
		addr.isLinkLocalAddress();
		addr.isSiteLocalAddress();
		addr.isMulticastAddress();
		addr.isMCGlobal();
		addr.isMCNodeLocal();
		addr.isMCLinkLocal();
		addr.isMCSiteLocal();
		addr.isMCOrgLocal();
	}
}
