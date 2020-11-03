package com.blog.demo.thread.tools;

import java.util.concurrent.CyclicBarrier;

/*
 * https://blog.csdn.net/chennai1101/article/details/84761500
 */
public class CyclicBarrierThread extends Thread {
	
	CyclicBarrier barrier;
	
	public CyclicBarrierThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	public void run() {
		try {
			System.out.println(currentThread().getName() + " start");
			Thread.sleep(1000);
			barrier.await();
			System.out.println(currentThread().getName() + " end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
//		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {			
//			@Override
//			public void run() {
//				System.out.println("In Runnable");
//			}
//		});
		for (int i = 0; i < 3; i++) {
			new CyclicBarrierThread(barrier).start();
		}
	}

}
