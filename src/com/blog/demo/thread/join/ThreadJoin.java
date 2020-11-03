package com.blog.demo.thread.join;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745253
 */
public class ThreadJoin {
	
	public static void main(String[] args) {
		try {
			ThreadA threadA = new ThreadA();
			threadA.start();
			
			System.out.println("In Main begin at " + System.currentTimeMillis());
//			threadA.join();
//			threadA.join(2000);
			threadA.join(4000);
			System.out.println("In Main end at " + System.currentTimeMillis());
		} catch (InterruptedException e) {
		}
	}
	
	static class ThreadA extends Thread {
		public void run() {
			try {
				System.out.println("In ThreadA begin at " + System.currentTimeMillis());
				Thread.sleep(3000);
				System.out.println("In ThreadA end at " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
