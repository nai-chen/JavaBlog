package com.blog.demo.application.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * https://blog.csdn.net/chennai1101/article/details/84783794
 */
public class SocketTcpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		int TCP_SERVER_PORT = 1234;

		try {
			Socket socket = new Socket(serverIp, TCP_SERVER_PORT);
			// 获取输入流
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// 生成输出流
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			String outMsg = "Socket TCP connecting to " + TCP_SERVER_PORT
					+ System.getProperty("line.separator");
			out.write(outMsg);
			out.flush();

			String inMsg = in.readLine();
			System.out.println(inMsg);
			
			// 关闭连接
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
