package com.shinhan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String converToString(Date d1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String str = sdf.format(d1);
		return str;
	}

	public static Date coverToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Date d2 = null;
		try {
			d2 = sdf.parse(str);
			System.out.println(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d2;
	}
	
	public static java.sql.Date converToSQLdATE(Date d){
		return new java.sql.Date(d.getTime());
	}

}
