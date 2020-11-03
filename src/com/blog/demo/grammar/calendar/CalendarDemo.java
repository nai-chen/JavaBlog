package com.blog.demo.grammar.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * https://blog.csdn.net/chennai1101/article/details/83995591
 */
public class CalendarDemo {
	
	public static void main(String[] args) {
		new CalendarDemo().test();		
	}
	
	private void test() {
		Calendar calendar = Calendar.getInstance();
		printCalendar(calendar);
		
		calendar.setTime(new Date(System.currentTimeMillis() - 60000));
		printCalendar(calendar);
		
		calendar.setTimeInMillis(System.currentTimeMillis() + 60000);
		printCalendar(calendar);

		setFunTest();
		delayTest();
		getFunTest();
		addFunTest();
	}
	
	void setFunTest() {
		System.out.println("========= set fun ===========");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DATE, 20);
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 12);
		calendar.set(Calendar.SECOND, 50);
		printCalendar(calendar); // 2000-06-20 14:12:50
	}
	
	void delayTest() {
		System.out.println("========= delay ===========");
		Calendar calendar = Calendar.getInstance();		
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.DATE, 31);
		printCalendar(calendar);
		
		calendar.set(Calendar.MONTH, Calendar.JULY);
		printCalendar(calendar);
		
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.DATE, 31);
		calendar.set(Calendar.MONTH, Calendar.JULY);
		printCalendar(calendar);
	}

	void getFunTest() {
		System.out.println("========= get fun ===========");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		System.out.println(calendar.getMaximum(Calendar.DATE)); // 31
		System.out.println(calendar.getActualMaximum(Calendar.DATE)); // 30
	}
	
	void addFunTest() {
		System.out.println("========= add fun ===========");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DATE, 31);
		printCalendar(calendar);
		
		calendar.add(Calendar.MONTH, 1);
		printCalendar(calendar);
		
		calendar.add(Calendar.MONTH, 11);
		printCalendar(calendar);
	}
	
	private  void printCalendar(Calendar calendar) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
	}

}
