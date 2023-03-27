package com.blog.demo.grammar.wait;

/*
 * https://blog.csdn.net/chennai1101/article/details/84744748
 */
public class ThreadNotify {

	public static void main(String[] args) {
		Object lock = new Object();		
		new ThreadA(lock).start();
		new ThreadA(lock).start();
		new ThreadB(lock).start();
	}
	
	static class ThreadA extends Thread {
		Object lock;
		
		ThreadA(Object lock) {
			this.lock = lock;
		}
		
		public void run() {
			synchronized (lock) {
				try {
					System.out.println("In ThreadA begin at " + System.currentTimeMillis());
					lock.wait();
					System.out.println("In ThreadA end at " + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class ThreadB extends Thread {
		Object lock;
		
		ThreadB(Object lock) {
			this.lock = lock;
		}
		
		public void run() {
			synchronized (lock) {
				System.out.println("In ThreadB begin at " + System.currentTimeMillis());
				lock.notify();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("In ThreadB end at " + System.currentTimeMillis());
			}
		}
	}

}
