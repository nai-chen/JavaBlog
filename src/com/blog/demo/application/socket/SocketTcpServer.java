package com.blog.demo.application.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783794
 */
public class SocketTcpServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int TCP_SERVER_PORT = 1234;

		// ����һ��ServerSocket����
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(TCP_SERVER_PORT);
			// ������������
			Socket socket = serverSocket.accept();
			// ��ȡ������
			BufferedReader in = new BufferedReader(new 	
					InputStreamReader(socket.getInputStream()));
			// ��ȡ�����
			BufferedWriter out = new BufferedWriter(new	
					OutputStreamWriter(socket.getOutputStream()));
			// ��ȡ������Ϣ��ת��Ϊ�ַ���
			String incomingMsg = in.readLine();
			System.out.println(incomingMsg);

			String outgoingMsg = "receive data from port " + TCP_SERVER_PORT 
					+ System.getProperty("line.separator");
			out.write(outgoingMsg);
			out.flush();

			socket.close();
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
