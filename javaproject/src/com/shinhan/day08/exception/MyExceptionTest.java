package com.shinhan.day08.exception;

import java.io.IOException;

public class MyExceptionTest {

	public static void main(String[] args) {
		// f1(5);
		//f4();
		System.out.println("====Main END====");
	}

	private static void f4() throws IOException {
		int i = System.in.read();
		System.out.println(i);
	}

	private static void f3() {
		String socre = "100점";

		try {
			int scoreInt = Integer.parseInt(socre);
			System.out.println("점수: " + scoreInt);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

	}

	private static void f2() {
		// int[] arr = new int[3];
		int[] arr = null;
		try {
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("====Method2 END====");
	}

	private static void f1(int b) {
		try {
			int a = 10 / b;
			System.out.println(a);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("====Method END====");
	}

}
