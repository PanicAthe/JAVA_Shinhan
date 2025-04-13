package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		f7();
	}

	private static void f7() {
		String str1 = "신한DS 소프트아카데미";
		
	}

	private static void f6() {
		PersonVO p = new PersonVO("홍길동", 20,"도적");
	}

	private static void f5() {
		HashSet<Coffee> data = new HashSet<Coffee>();
		data.add(new Coffee("에이드", 3000));
		data.add(new Coffee("에이드", 3000));
		data.add(new Coffee("청포도에이드", 3000));
		data.add(new Coffee("레몬에이드", 3000));
		data.add(new Coffee("블루레몬에이드", 3000));
		data.add(new Coffee("블루베리에이드", 3000));
		for (Coffee s : data) {
			System.out.println(s);
		}
	}

	private static void f4() {
		HashSet<String> data = new HashSet<String>();
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		for (String s : data) {
			System.out.println();
		}
	}

	private static void f3() {
		Coffee obj1 = new Coffee("아메리카노", 1000);
		Coffee obj2 = new Coffee("청포도에이드", 3000);

		System.out.println(obj1);
		System.out.println(obj1.hashCode());
		System.out.println(obj1.toString());
		System.out.println(obj2);
		System.out.println(obj2.hashCode());
		System.out.println(obj2.toString());

		System.out.println(obj1 == obj2);

	}

	private static void f2() {
		String obj1 = new String("자바");
		String obj2 = new String("자바");

		System.out.println(obj1);
		System.out.println(obj1.hashCode());
		System.out.println(obj2);
		System.out.println(obj2.hashCode());

		System.out.println(obj1 == obj2);

	}

	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1);
		System.out.println(obj2);
	}

}
