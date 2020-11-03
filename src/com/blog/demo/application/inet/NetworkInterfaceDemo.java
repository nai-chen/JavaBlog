package com.blog.demo.application.inet;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783768
 */
public class NetworkInterfaceDemo {
	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface ni = interfaces.nextElement();
			System.out.println(ni);
		}
		System.out.println("---------------------------");
		NetworkInterface ni = NetworkInterface.getByName("eth0");
		System.out.println(ni);
	}
	
}
