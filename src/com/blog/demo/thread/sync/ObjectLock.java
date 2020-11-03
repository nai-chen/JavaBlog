package com.blog.demo.thread.sync;

/*
 * https://blog.csdn.net/chennai1101/article/details/84745728
 */
public class ObjectLock {
	
    public static void main(String[] args) {
        ObjectLock lock = new ObjectLock();

        ThreadA threadA = new ThreadA(lock);
        threadA.start();

        ThreadB threadB = new ThreadB(lock);
        threadB.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();
    }

    public synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + ": methodA begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ": methodA end");
    }

    public void methodB() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": methodB begin");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + ": methodB end");
        }
    }

    public static class ThreadA extends Thread {
        ObjectLock lock;

        ThreadA(ObjectLock lock) {
            this.lock = lock;
            setName("A");
        }

        @Override
        public void run() {
            lock.methodA();
        }
    }

    public static class ThreadB extends Thread {
        ObjectLock lock;

        ThreadB(ObjectLock lock) {
            this.lock = lock;
            setName("B");
        }

        @Override
        public void run() {
            lock.methodB();
        }
    }

    public static class ThreadC extends Thread {
        ObjectLock lock;

        ThreadC(ObjectLock lock) {
            this.lock = lock;
            setName("C");
        }
	
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": methodC begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + ": methodC end");
            }	
        }
    }
	
}