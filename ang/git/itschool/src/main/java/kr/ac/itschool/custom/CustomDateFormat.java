package kr.ac.itschool.custom;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CustomDateFormat {
  public static String mydateFormat(){
	  
				Calendar calendar = new GregorianCalendar();
				int year = calendar.get(Calendar.YEAR);
				int Month = calendar.get(Calendar.MONTH)+1;
				String smonth = String.format("%02d", Month);
				int day = calendar.get(Calendar.DATE);
				String sday = String.format("%02d", day);
				int hour = calendar.get(Calendar.HOUR);
				String shour = String.format("%02d", hour);
				int min = calendar.get(Calendar.MINUTE);
				String smin = String.format("%02d",min);
				int sec = calendar.get(Calendar.SECOND);
				int amPm = calendar.get(Calendar.AM_PM);
				String sampm = amPm == Calendar.AM ? "오전" : "오후";
				String today = year+"/" + smonth+"/"+sday+"/"+sampm+" "
				+shour+":"+min+":"+sec;
				
				return today;
	}  
 }
