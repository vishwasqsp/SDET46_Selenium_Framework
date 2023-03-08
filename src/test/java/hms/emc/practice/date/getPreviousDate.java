package hms.emc.practice.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getPreviousDate {
	public static void main(String[] args) throws ParseException {
		String dateString = "09_05_2019";
		SimpleDateFormat properDateFormat = new SimpleDateFormat("dd_mm_yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(properDateFormat.parse(dateString));
		calendar.add(Calendar.DAY_OF_MONTH, -11);
		String date = properDateFormat.format(calendar.getTime());
		System.out.println(date);
}
}
