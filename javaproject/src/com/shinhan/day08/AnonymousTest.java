package com.shinhan.day08;

interface MyInterface {
	public abstract void use();
}

class MyClass implements MyInterface {

	@Override
	public void use() {
		// TODO Auto-generated method stub
	}
}

public class AnonymousTest {
	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		
	}

	private static void f1() {
		MyInterface my1 = new MyInterface() {
			@Override
			public void use() {
				System.out.println();
			}
		};
	}
}
