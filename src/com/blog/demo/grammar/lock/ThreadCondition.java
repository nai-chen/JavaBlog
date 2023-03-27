package com.blog.demo.grammar.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://blog.csdn.net/chennai1101/article/details/84746763
 */
public class ThreadCondition {
	
	public static void main(String[] args) {
		try {
			ThreadA threadA = new ThreadA();
			threadA.start();

			Thread.sleep(3000);
			
			threadA.singal();
		} catch (InterruptedException e) {
		}
	}
	
	static class ThreadA extends Thread {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();
		
		public void run() {			
			try {
				lock.lock();
				System.out.println("ThreadA begin await " + System.currentTimeMillis());
				condition.await();
				System.out.println("ThreadA end await " + System.currentTimeMillis());
			} catch (InterruptedException e) {
			} finally {
				lock.unlock();
			}
		}
		
		public void singal() {
			lock.lock();
			System.out.println("ThreadA begin signal " + System.currentTimeMillis());
			condition.signal();
			System.out.println("ThreadA end signal " + System.currentTimeMillis());
			
			lock.unlock();
		}
	}
	
}
