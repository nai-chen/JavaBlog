package com.blog.demo.thread.wait;

/*
 * https://blog.csdn.net/chennai1101/article/details/84744748
 */
public class ThreadWait {
	
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
	}
	
	static class ThreadA extends Thread {
		
		public void run() {
			Object lock = new Object();
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
		
		public void run() {
			Object lock = new Object();
			synchronized (lock) {
				try {
					System.out.println("In ThreadB begin at " + System.currentTimeMillis());
					lock.wait(2000);
					System.out.println("In ThreadB end at " + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
