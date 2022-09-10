package com;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//this class is used to get date and time 
public class DateAndTime {

	// to get date in E MMM dd HH:mm:ss zzz yyyy format
	public static String dateTime() {

		ZonedDateTime time1 = ZonedDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss zzz yyyy");
		String currentTime = time1.format(f);
		return currentTime;
	}

	// to get date in E MMM dd HH format
	public static String dateAndHour() {

		ZonedDateTime time1 = ZonedDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("E MMM dd HH:");
		String currentdate = time1.format(f);
		return currentdate;
	}

	// to get today's date in E MM dd format
	public static String today() {

		ZonedDateTime time1 = ZonedDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("E MMM dd");
		String currentdate = time1.format(f);
		return currentdate;
	}

	//to get this month in MMM format
	public static String thisMonth() {

		ZonedDateTime time1 = ZonedDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM");
		String currentdate = time1.format(f);
		return currentdate;
	}

}
