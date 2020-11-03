package com.blog.demo.thread.sleep;

/*
 * https://blog.csdn.net/chennai1101/article/details/84764558
 */
public class ThreadSleep extends Thread {

	@Override
	public void run() {
		System.out.println("ThreadSleep begin " + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}		
		System.out.println("ThreadSleep end " + System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		new ThreadSleep().start();
	}
	
}
