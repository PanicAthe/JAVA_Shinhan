package com.shinhan.day11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Properties;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String[] args) {
		f6();
	}

	private static void f6() {
		Student s1 = new Student("1", "강아지", "컴공과", 100);
		Student s2 = new Student("2", "고양이", "국문과", 70);
		Student s3 = new Student("3", "친칠라", "영문과", 80);
		Student s4 = new Student("4", "햄스터", "국문과", 70);
		Student s5 = new Student("5", "다람쥐", "법학과", 80);

		Student[] arr = { s1, s2, s3, s4, s5 };

		Arrays.sort(arr);
		
		for(Student s : arr) {
			System.out.println(s);
		}
	}

	private static void f5() {
		TreeSet<Integer> data = new TreeSet<>();
		data.add(100);
		data.add(1700);
		data.add(300);
		data.add(1100);
		data.add(500);

		for (Integer n : data) {
			System.out.println(n);
		}
	}

	private static void f3() {
		Board[] arr = { new Board("b", "a2", "a1"), new Board("a", "a1", "a1"), new Board("aw", "a2", "a3") };

		Arrays.sort(arr);
		for (Board b : arr) {
			System.out.println(b);
		}
		Arrays.sort(arr, new Comparator<Board>() {

			@Override
			public int compare(Board o1, Board o2) {
				return o1.getContent().compareTo(o2.getContent());
			}

		});

		for (Board b : arr) {
			System.out.println(b);
		}

	}

	private static void f2() {
		Properties pro = new Properties();

		InputStream Is = CollectionTest.class.getResourceAsStream("/com/shinhan/day11/oracle.properties");
		try {
			pro.load(Is);
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String userId = pro.getProperty("userId");
			String password = pro.getProperty("password");
			String score = pro.getProperty("score");

			System.out.println(driver);
			System.out.println(url);
			System.out.println(userId);
			System.out.println(password);
			System.out.println(score);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void f1() {
		Hashtable<String, Integer> data = new Hashtable<>();
		Runnable r1 = () -> {
			for (int i = 1; i <= 100; i++) {
				data.put(String.valueOf(i), i);
			}

		};

		Runnable r2 = () -> {
			for (int i = 1100; i <= 3000; i++) {
				data.put(String.valueOf(i), i);
			}

		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data.size());
	}

}
