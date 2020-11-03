package com.blog.demo.thread.tools;

import java.util.concurrent.CountDownLatch;

/*
 * https://blog.csdn.net/chennai1101/article/details/84761500
 */
public class CountDownLatchThread extends Thread {

	CountDownLatch latch;
	
	public CountDownLatchThread(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		try {
			System.out.println(currentThread().getName() + " start");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println(currentThread().getName() + " end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		
		for (int i = 0; i < 2; i++) {
			new CountDownLatchThread(latch).start();
		}
		
		System.out.println(Thread.currentThread().getName() + " start");
		latch.await();
		System.out.println(Thread.currentThread().getName() + " end");
	}
	
}
