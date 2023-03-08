package com.tyss.genericUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This class is used for multiple java methods
 * @author User
 *
 */
public class JavaUtility {

	/**
	 * This method is used for generating random number
	 * @param limitValue
	 * @return
	 */
	public int getRandomNumber(int limitValue)
	{
		return new Random().nextInt(limitValue);
	}
	/**
	 * This method is used to decode the argument value
	 * @param s
	 * @return
	 */
	public String decode(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}
	/**
	 * This method is used to encode the argument value
	 * @param s
	 * @return
	 */
	public String encode(String s)
	{
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}
	public String[] split(String s, String startegy)
	{
		return s.split(startegy);
	}
	/**
	 * This method is used to get current date
	 * @return
	 */
	public String getCurrentDateTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		return sdf.format(new Date());
	}
	/**
	 * This method is used to get current date by passing pattern of date whichever is required
	 * @param pattern
	 * @return
	 */
	public String getCurrentDateTime(String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	/**
	 * This method is used to add the days count for a current date
	 * @param days
	 * @return
	 */
	public String addCurrentDate(int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
	/**
	 * This method is used to add the days count for a current date
	 * @param days
	 * @return
	 */
	public String addOrSubstractDate(int days) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
	/**
	 * This method is used to add the days count and date format to get required date
	 * @param date
	 * @param days
	 * @return
	 */
	public String addOrSubstractDate(String date, int days) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
}
