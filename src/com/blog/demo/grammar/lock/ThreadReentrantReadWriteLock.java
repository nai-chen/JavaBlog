package com.blog.demo.grammar.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * https://blog.csdn.net/chennai1101/article/details/84746763
 */
public class ThreadReentrantReadWriteLock {	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		try {
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName()
					+ " read " + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public void write() {
		try {
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()
					+ " write " + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	static class WriteThread extends Thread {
		private ThreadReentrantReadWriteLock service;
		
		public WriteThread(ThreadReentrantReadWriteLock service) {
			this.service = service;
		}
		
		public void run() {
			service.write();
		}
	}
	
	static class ReadThread extends Thread {
		private ThreadReentrantReadWriteLock service;
		
		public ReadThread(ThreadReentrantReadWriteLock service) {
			this.service = service;
		}
		
		public void run() {
			service.read();
		}
	}
	
	public static void main(String[] args) {
		ThreadReentrantReadWriteLock service = new ThreadReentrantReadWriteLock();
		
//		ReadThread readThread1 = new ReadThread(service);
//		readThread1.setName("ReadThread1");
//		readThread1.start();
//		
//		ReadThread readThread2 = new ReadThread(service);
//		readThread2.setName("ReadThread2");
//		readThread2.start();

		WriteThread writeThread = new WriteThread(service);
		writeThread.setName("WriteThread");
		writeThread.start();

		ReadThread readThread = new ReadThread(service);
		readThread.setName("ReadThread");
		readThread.start();
	}
		
}
