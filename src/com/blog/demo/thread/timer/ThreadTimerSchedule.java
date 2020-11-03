package com.blog.demo.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/*
 * https://blog.csdn.net/chennai1101/article/details/84246528
 */
public class ThreadTimerSchedule {
	public static void main(String[] args) {
		Timer timer = new Timer();

		final TimerTask task = new TimerTask() {
			int i = 0;
			long time = System.currentTimeMillis();
			
			@Override
			public void run() {
				System.out.println("TimerTask:" + (System.currentTimeMillis() - time));
				try {
					if (i == 0) {
						Thread.sleep(4000);
					} else if (i == 1) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
				}
				i++;
			}
		};
//		timer.scheduleAtFixedRate(task, 0, 3000);
		timer.schedule(task, 0, 3000);
	}	
}
