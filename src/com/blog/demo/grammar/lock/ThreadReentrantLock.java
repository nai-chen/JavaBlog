package com.blog.demo.grammar.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://blog.csdn.net/chennai1101/article/details/84746763
 */
public class ThreadReentrantLock {
	
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		
		for (int i = 0; i < 3; i++) {
			Thread th = new Thread(threadA);
			th.setName("Thread" + i);
			th.start();
		}
	}
	
	static class ThreadA extends Thread {
		private Lock lock = new ReentrantLock(false);
		
		public void run() {
			System.out.println(currentThread().getName() + " run");
			try {
				lock.lock();
				System.out.println(currentThread().getName() + " begin");
				Thread.sleep(1000);
				System.out.println(currentThread().getName() + " end");
			} catch (InterruptedException e) {
			} finally {
				lock.unlock();
			}
		}
	}
	
}
