package com.blog.demo.application.telnetclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.net.telnet.TelnetClient;

/*
 * https://blog.csdn.net/chennai1101/article/details/84789239
 */
public class TelnetClientDemo {
	private final static String serverIP = "192.168.4.58";
	
	public static void main(String[] args) {
		TelnetClientDemo demo = new TelnetClientDemo();
		demo.connectToServer(serverIP);
	}
	
	private void connectToServer(String server) {
		TelnetClient telnetClient = new TelnetClient("VT220");
		try {
			telnetClient.connect(server);
			
			InputStream remoteInput = telnetClient.getInputStream();
			OutputStream remoteOutput = telnetClient.getOutputStream();
			
			// ReadThread线程监听输入，并输出到System.err
			ReadThread readThread = new ReadThread(remoteInput);
			readThread.start();
			
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(remoteOutput);
			
			while ((line = reader.readLine()) != null) {
				if (line.equals("exit")) {
					break;
				}
				pw.println(line);
				pw.flush();
				System.err.println("request: " + line);
			}
			pw.close();
			
			readThread.pause();
			readThread.join();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (telnetClient.isConnected()) {
				try {
					telnetClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class ReadThread extends Thread {
		private InputStream mInput;
		private boolean mStopped;
		
		public ReadThread(InputStream input) {
			mInput = input;
		}
		
		@Override
		public void run() {
			super.run();
			
			try {
				byte[] buffer = new byte[1024];
				while (!mStopped) {
					int len = mInput.read(buffer);
					if (len != -1) {
						System.err.print(new String(buffer, 0, len, "GBK"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (mInput != null) {
					try {
						mInput.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void pause() {
			mStopped = true;
		}

	}

}
