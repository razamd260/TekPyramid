package com.comcast.crm.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
      
	   public int getRandomNumber() {
		   Random random=new Random();
		   int number=random.nextInt(123);
		   return number;
		   
	   }
	   
	   public String getSystemDate() {
		   Date d=new Date();
		   SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyy");
		   String currentdate=sim.format(d);
		   return currentdate;
	   }
	   
	   public String getRequiredDate(int days) {
		   Date dataobj=new Date();
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			String actdate=sim.format(dataobj);
			System.out.println(actdate);
			Calendar cal=sim.getCalendar();
		//	cal.add(Calendar.DAY_OF_MONTH,30);
		    String datarequird=sim.format(cal.getTime());
			return datarequird;
	   }
}
