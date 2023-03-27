package com.blog.demo.application.timer;

import java.util.Timer;
import java.util.TimerTask;

/*
 * https://blog.csdn.net/chennai1101/article/details/84246528
 */
public class ThreadTimer {
	public static void main(String[] args) {
		Timer timer = new Timer(true);

		final TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("TimerTask");
				cancel();
			}
		};
		timer.schedule(task, 0);		
	}	
}
