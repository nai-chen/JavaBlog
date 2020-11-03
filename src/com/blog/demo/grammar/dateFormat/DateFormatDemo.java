package com.blog.demo.grammar.dateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * https://blog.csdn.net/chennai1101/article/details/84027391
 */
public class DateFormatDemo {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		
		try {
			Date date = df.parse("2011-05-20 14:13:40");
			System.out.println(date.getTime());
		} catch (ParseException e) {
		}
	}

}
