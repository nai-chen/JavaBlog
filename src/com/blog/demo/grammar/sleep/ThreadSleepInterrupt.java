package com.blog.demo.grammar.sleep;

/*
 * https://blog.csdn.net/chennai1101/article/details/84764558
 */
public class ThreadSleepInterrupt extends Thread {	
	
	@Override
	public void run() {
		System.out.println("ThreadSleepInterrupt begin " + System.currentTimeMillis());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadSleepInterrupt end " + System.currentTimeMillis());	
	}
	
	public static void main(String[] args) {
		Thread t = new ThreadSleepInterrupt();
		t.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	
		t.interrupt();
	}

}
