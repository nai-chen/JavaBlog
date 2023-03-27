package com.blog.demo.grammar.wait;

/*
 * https://blog.csdn.net/chennai1101/article/details/84744748
 */
public class ThreadWaitInterrupt {
	
	public static void main(String[] args) {		
		try {
			Object lock = new Object();
			ThreadA threadA = new ThreadA(lock);
			threadA.start();

			Thread.sleep(1000);
			threadA.interrupt();
			
//			Thread.sleep(1000);
//			threadA.start();
		} catch (InterruptedException e) {
		}
	}
	
	static class ThreadA extends Thread {
		private Object lock;

		public ThreadA(Object lock) {
			this.lock = lock;
		}

		public void run() {
			System.out.println("In ThreadA start at " + System.currentTimeMillis());
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			System.out.println("In ThreadA end at " + System.currentTimeMillis());
		}
	}

}
