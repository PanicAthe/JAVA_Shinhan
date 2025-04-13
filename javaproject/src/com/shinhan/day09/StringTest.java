package com.shinhan.day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.shinhan.util.DateUtil;

public class StringTest {

	public static void main(String[] args) {
		f8();
	}

	private static void f8() {
//		Date d1 = new Date();
//		System.out.println(d1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//		String str = sdf.format(d1);
//		System.out.println(DateUtil.converToString(new Date()));

		String str2 = "2025-04-11 15:44:50";
		Date d2 = DateUtil.coverToDate(str2);
	}

	private static void f7() {
		String data = "100";
		int i = Integer.parseInt(data);
		double d = Double.parseDouble(data);
	}

	private static void f3() {
		String s1 = "자바";
		StringBuilder sb = new StringBuilder("자바");
	}

	private static void f1() {
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		char[] arr = new char[] { '자', '바' };
		String s4 = new String(arr);
		System.out.println(s4);
	}

}
