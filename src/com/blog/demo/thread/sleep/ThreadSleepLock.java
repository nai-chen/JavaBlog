package com.blog.demo.thread.sleep;

/*
 * https://blog.csdn.net/chennai1101/article/details/84764558
 */
public class ThreadSleepLock extends Thread {
	Object lock;
	
	public ThreadSleepLock(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("ThreadSleepLock begin " + System.currentTimeMillis());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("ThreadSleepLock end " + System.currentTimeMillis());			
		}
	}
	
	public static void main(String[] args) {
		Object lock = new Object();
		new ThreadSleepLock(lock).start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		
		synchronized (lock) {
			System.out.println("main end " + System.currentTimeMillis());			
		}
	}

}
