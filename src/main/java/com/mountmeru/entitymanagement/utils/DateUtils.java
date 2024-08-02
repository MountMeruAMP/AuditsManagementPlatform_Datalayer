package com.mountmeru.entitymanagement.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DateUtils {

	public boolean isValidDateMMddyyyyFormat(String date)
	{
		SimpleDateFormat sdfrmt = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
		sdfrmt.setLenient(false);
		try
		{
			Date javaDate = sdfrmt.parse(date);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public static int compareTwoDatesAsString(String d1,String d2)
	{
		try{	                 
			SimpleDateFormat sdf = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);
			if(date1.after(date2)){
				//System.out.println("Date1 is after Date2");
				return 1;
			}			
			else if(date1.before(date2)){
				//System.out.println("Date1 is before Date2");
				return 2;
			}			
			else if(date1.equals(date2)){
				//System.out.println("Date1 is equal Date2");
				return 0;
			}
		}
		catch(ParseException ex){
			return -1;
		}
		return -1;		
	}
	public String getTodaysDateAsString()
	{
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy).format(date);
		return modifiedDate;
	}
	public Date getTodaysDate()
	{
		Date date = new Date();
		return date;
	}
	public String parseDateToString(Date date)
	{
		try {
		String modifiedDate= new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy).format(date);
		return modifiedDate;
		}
		catch(Exception e)
		{
			throw  new RuntimeErrorException(new Error("Invalid Date Format"));
		}
	}
	/**
	 * Adding number of days to a given date.
	 * @param date
	 * @param days
	 * @return
	 */
	public String addDaysToDateReturnString(Date date, int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
		Calendar c = Calendar.getInstance();
		c.setTime(date); // Using today's date
		c.add(Calendar.DATE, days); // Adding 5 days
		String output = sdf.format(c.getTime());		
		return output;		 
	}
	public Date addDaysToDateReturnDate(Date date, int days)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date); // Using today's date
		c.add(Calendar.DATE, days); // Adding 5 days
		Date  outputDate = c.getTime();		
		return outputDate;		 
	}
	
	/**
	 * Adding number of days today.
	 * @param date
	 * @param days
	 * @return
	 */
	public String addDaysToToday( int days)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, days); // Adding 5 days
		String output = sdf.format(c.getTime());		
		return output;		
	}
	/**
	 * Adding number of days today.
	 * @param date
	 * @param days
	 * @return
	 */
	public Date subtractDaysToToday(int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, -days); // subtracting  days
//		String output = sdf.format(c.getTime());
		return c.getTime();
	}

	/**
	 * Adding number of days to a given date.
	 * @param date
	 * @param days
	 * @return
	 */
	public Date subtractDaysToDate(Date date, int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.dateFormat_mm_dd_yyyy);
		Calendar c = Calendar.getInstance();
		c.setTime(date); // Using today's date
		c.add(Calendar.DATE, -days); // subtracting  days
//		String output = sdf.format(c.getTime());
		return c.getTime();
	}
	/**
	 * This method compares effective date and through dates.
	 * @param effectiveDate
	 * @param throughDate
	 */
	public void validateEffectiveAndThroughDates(Date effectiveDate, Date throughDate)
	{
		if(!StringUtils.isEmpty(effectiveDate) && !StringUtils.isEmpty(throughDate))
		{
			if(1== compareTwoDatesAsString(parseDateToString(effectiveDate), parseDateToString(throughDate)))
			{
				throw new RuntimeErrorException(new Error("Effective Date cannot be greater than through date"));
			}
		}			
	}
	/**
	 * This method return the time stamp in 2021-03-24 16:48:05.591 format
	 * @return
	 */
	public Timestamp getCurrentTimeStamp()
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
	}
	/**
	 * This method converts timestamp into formatted date.
	 * @param date
	 * @return
	 */
	public String convertTimeStampToDate(Date date, String format)
	{	
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date.getTime());
    }
	public static Date convertStringToDate(String dateString, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		try {
			if (pattern.contains("T")) {
				LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
				return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
			} else {
				LocalDate localDate = LocalDate.parse(dateString, formatter);
				return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Invalid date format: " + dateString, e);
		}
	}
	
	
	public int getDatefromDate(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
}
