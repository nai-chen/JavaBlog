package com.blog.demo.grammar.join;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745253
 */
public class ThreadJoinError {
	
	public static void main(String[] args) {
		try {
			ThreadA threadA = new ThreadA();
			threadA.start();

			ThreadB threadB = new ThreadB(threadA);
			threadB.start();
			
			System.out.println("In Main begin at " + System.currentTimeMillis());
			threadA.join();
			System.out.println("In Main end at " + System.currentTimeMillis());
		} catch (InterruptedException e) {
		}
	}
	
	static class ThreadA extends Thread {
		public void run() {
			try {
				System.out.println("In ThreadA begin at " + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("In ThreadA end at " + System.currentTimeMillis());
			} catch (InterruptedException e) {
			}				
		}
	}
	
	static class ThreadB extends Thread {
		ThreadA threadA;
		
		ThreadB(ThreadA threadA) {
			this.threadA = threadA;
		}
		
		public void run() {
			synchronized (threadA) {
				try {
					System.out.println("In ThreadB begin at " + System.currentTimeMillis());
					Thread.sleep(5000);
					System.out.println("In ThreadB end at " + System.currentTimeMillis());
				} catch (InterruptedException e) {
				}				
			}
		}
	}
	
}
