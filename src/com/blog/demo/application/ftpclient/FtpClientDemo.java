package com.blog.demo.application.ftpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/*
 * https://blog.csdn.net/chennai1101/article/details/84789043
 */
public class FtpClientDemo {
	
	private final String serverIP = "192.168.4.58";
	private final String USERNAME = "cn";
	private final String PASSWORD = "nai-chen";

	public static void main(String[] args) {
		File file = new File("E:\\study\\Learn.Objective-C.on.the.Mac.2nd.Edition.pdf");
		FtpClientDemo demo = new FtpClientDemo();
		demo.upload(file.getAbsolutePath(), file.getName());
		
		demo.download("demo.txt", "E:\\ftpserver\\copy.txt");
	}
	
	private boolean upload(String absolutePath, String name) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(serverIP);
			ftpClient.login(USERNAME, PASSWORD);

			int reply = ftpClient.getReplyCode();
			System.out.println("reply = " + reply);
			if (FTPReply.isPositiveCompletion(reply)) {
				// 设置文件类型
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
				ftpClient.enterLocalPassiveMode();
				
				InputStream input = new FileInputStream(absolutePath);
				boolean result = ftpClient.storeFile(name, input);
				System.out.println("result = " + result);
				input.close();
				ftpClient.logout();
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	private boolean download(String remotePath, String localPath) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(serverIP);
			ftpClient.login(USERNAME, PASSWORD);

			int reply = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply)) {
				OutputStream output = new FileOutputStream(localPath);				
				ftpClient.retrieveFile(remotePath, output);
				output.close();
				
				ftpClient.logout();
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}