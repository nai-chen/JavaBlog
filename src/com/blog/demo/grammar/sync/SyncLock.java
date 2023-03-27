package com.blog.demo.grammar.sync;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745728
 */
public class SyncLock {
	
//	private volatile boolean condition = true;
	private boolean condition = true;

	public void methodA() {
		System.out.println(Thread.currentThread().getName() + ": methodA begin");
		while(condition) {
//			synchronized (this) {
//			}
		}
		System.out.println(Thread.currentThread().getName() + ": methodA end");
	}
	
	public void stopMethodA() {
		condition = false;
	}
	
	
	public static void main(String[] args) {
		SyncLock lock = new SyncLock();
		
		ThreadA threadA = new ThreadA(lock);
		threadA.start();
		
		ThreadB threadB = new ThreadB(lock);
		threadB.start();
	}
	
	public static class ThreadA extends Thread {
		SyncLock lock;
		
		ThreadA(SyncLock lock) {
			this.lock = lock;
		}
		
		@Override
		public void run() {
			lock.methodA();
		}
	}
	
	public static class ThreadB extends Thread {
		SyncLock lock;
		
		ThreadB(SyncLock lock) {
			this.lock = lock;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			lock.stopMethodA();
		}
	}

}
