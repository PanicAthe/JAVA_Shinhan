package com.shinhan.day08;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(() -> System.out.println("람다식으로 매개변수 보내기"));
	}
}