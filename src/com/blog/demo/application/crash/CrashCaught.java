package com.blog.demo.application.crash;

public class CrashCaught extends Thread {
	private boolean caught;

	public CrashCaught(boolean caught) {
		this.caught = caught;
	}
	
	@Override
	public void run() {
		System.out.println(getName());
		
		if (caught) {
			setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		throw new NullPointerException();
	}
	
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		new CrashCaught(false).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		new CrashCaught(true).start();
	}
	
	static class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
		String name;
		
		public MyUncaughtExceptionHandler() {
			this.name = Thread.currentThread().getName();
		}

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("In Handler " + name);
			System.out.println("Thread name " + t.getName());
			e.printStackTrace();
		}		
	}
	
}
