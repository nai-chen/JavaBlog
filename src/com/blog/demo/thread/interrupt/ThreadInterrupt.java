package com.blog.demo.thread.interrupt;

/*
 * https://blog.csdn.net/chennai1101/article/details/84765905
 */
public class ThreadInterrupt extends Thread {

	public void run() {
//		boolean pause = false;
//		while (!pause) {
//		}
		while (!isInterrupted()) {			
		}
		System.out.println("In ThreadInterrupt end at " + System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		try {
			ThreadInterrupt t = new  ThreadInterrupt();
			t.start();
			
			Thread.sleep(100);
			
			t.interrupt();
			System.out.println("In Thread main ThreadInterrupt.isInterrupted() = " + t.isInterrupted());
		} catch (InterruptedException e) {
		}
	}
	
}
