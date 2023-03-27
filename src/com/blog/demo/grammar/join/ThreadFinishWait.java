package com.blog.demo.grammar.join;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745253
 */
public class ThreadFinishWait {
	
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();	
		
		new ThreadB(threadA).start();
		new ThreadB(threadA).start();
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
    	
    	public ThreadB(ThreadA threadA) {
    		this.threadA = threadA;
		}
		
		public void run() {
			synchronized (threadA) {
				try {
					System.out.println("In ThreadB begin at " + System.currentTimeMillis());
					threadA.wait();
					System.out.println("In ThreadB end at " + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
