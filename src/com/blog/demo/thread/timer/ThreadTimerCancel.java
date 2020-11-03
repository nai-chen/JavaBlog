package com.blog.demo.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/*
 * https://blog.csdn.net/chennai1101/article/details/84246528
 */
public class ThreadTimerCancel {

	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task1 = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("task1");
			}
		};
		TimerTask task2 = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("task2");
			}
		};
		timer.schedule(task1, 0, 1000);
		timer.schedule(task2, 0, 1000);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		timer.cancel();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
		task1.cancel();
	}

}
