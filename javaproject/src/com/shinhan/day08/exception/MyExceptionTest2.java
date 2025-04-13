package com.shinhan.day08.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyExceptionTest2 {

	public static void main(String[] args) {
		f7();

	}

	private static void f7() {
		int score = -20;
		if (score < 0 || score > 100) {
			throw new MyException("0<= score <= 100 만 가능");
		}
	}

	private static void f6() {
		try {
			Class aa = Class.forName("com.shinhan.day08.Vehicle");
			System.out.println(aa.getName());
			System.out.println(aa.getSimpleName());
			System.out.println(aa.getModule());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f5() {
		try (FileReader fr = new FileReader("src/com/shinhan/day08/InnerClassTest.java")) {
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data); // 문자 출력
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); // read()는 IOException 던질 수 있음
		} finally {

		}
	}

	private static void f3() throws FileNotFoundException {
		FileReader fr = new FileReader("src/com/shinhan/day08/InnerClassTest.java");
		System.out.println("파일 존재");
	}

	private static void f2() {
		String str = null;

		try {
			System.out.println(str.length());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("반드시 실행");
		}
		System.out.println("===F3 END===");
	}

	private static void f1(int j) {
		int i = 10 / j;
		System.out.println(i);

	}

}
