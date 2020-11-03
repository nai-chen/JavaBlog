package com.blog.demo.application.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783794
 */
public class SocketUdpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		int UDP_SERVER_PORT = 1234;
		byte[] buffer = ("data from UDP client " + UDP_SERVER_PORT).getBytes();
		
        //�½�һ��DatagramSocket����
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            //��ʼ��InetAddress����
            InetAddress serverAddr = InetAddress.getByName(serverIp);

            //��ʼ��DatagramPacket����
             DatagramPacket dp = new DatagramPacket(buffer, buffer.length,
            		 serverAddr, UDP_SERVER_PORT);
            ds.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

	}

}
