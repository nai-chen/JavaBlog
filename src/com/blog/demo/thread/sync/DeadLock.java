package com.blog.demo.thread.sync;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745728
 */
public class DeadLock {
	
	public static void main(String[] args) {
		DeadLock lock1 = new DeadLock();
		DeadLock lock2 = new DeadLock();
		
		ThreadA threadA = new ThreadA(lock1, lock2);
		threadA.start();
		
		ThreadB threadB = new ThreadB(lock1, lock2);
		threadB.start();
	}

	public static class ThreadA extends Thread {
        DeadLock lock1, lock2;

        public ThreadA(DeadLock lock1, DeadLock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            setName("A");
        }

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": methodA begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ": methodAA");
                }
                System.out.println(Thread.currentThread().getName() + ": methodA end");
            }
        }
    }

    public static class ThreadB extends Thread {
        DeadLock lock1, lock2;

        public ThreadB(DeadLock lock1, DeadLock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;			
            setName("B");
        }

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": methodB begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + ": methodBB");
                }
                System.out.println(Thread.currentThread().getName() + ": methodB end");
            }
        }

    }
	
}
