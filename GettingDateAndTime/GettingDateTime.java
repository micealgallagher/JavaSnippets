/**
* Getting Date Time
* https://github.com/micealgallagher/JavaSnippets
*
* @copyright
* Copyright (C) 2014 Miceal Gallagher
*
* @license
* Licensed under the MIT licenses.
*/ 

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

class main {
	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date.toString());

		Date calDate = Calendar.getInstance().getTime();
		System.out.println(calDate.toString());

		Date startTime = new Date();
		startTime.setHours(17);
		startTime.setMinutes(0);
		startTime.setSeconds(0);
		System.out.println(startTime.toString());

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 17);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date calStartTime = calendar.getTime();
		System.out.println(calStartTime.toString());

		Date rawDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy HH:mm");
		System.out.println(dateFormat.format(rawDate));
	}
}