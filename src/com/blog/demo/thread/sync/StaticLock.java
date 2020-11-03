package com.blog.demo.thread.sync;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745728
 */
public class StaticLock {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();
	}
	
	public synchronized static void methodA() {
		System.out.println(Thread.currentThread().getName() + ": methodA begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ": methodA end");
	}
	
    public static class ThreadA extends Thread {
        
        ThreadA() {
            setName("A");
        }

        @Override
        public void run() {
            StaticLock.methodA();
        }
    }

    public static class ThreadB extends Thread {

        ThreadB() {
            setName("B");
        }

        @Override
        public void run() {
        	synchronized (StaticLock.class) {
                System.out.println(Thread.currentThread().getName() + ": methodB begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + ": methodB end");
            }
        }
    }
}
