package com.blog.demo.application.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783794
 */
public class SocketUdpServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int UDP_SERVER_PORT = 1234;
		int MAX_LEN = 1024;
		
		byte[] buffer = new byte[MAX_LEN];
		DatagramPacket dp = new DatagramPacket(buffer, MAX_LEN);
		
		// 新建一个DatagramSocket类
		DatagramSocket ds = null;
		try {
			// UDP服务器监听的端口
			ds = new DatagramSocket(UDP_SERVER_PORT);
			// 准备接收数据
			ds.receive(dp);
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}

}
