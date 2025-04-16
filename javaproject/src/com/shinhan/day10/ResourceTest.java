package com.shinhan.day10;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourceTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		Class cls = ResourceTest.class;

		// 리소스 파일 경로 출력
		URL url = cls.getResource("images/ham.jpg");
		System.out.println(url.getPath());

		// 텍스트 파일 읽기
		try (InputStream is = cls.getResourceAsStream("aa/my")) {
			if (is == null) {
				System.out.println("파일을 찾을 수 없습니다.");
				return;
			}

			int i;
			while ((i = is.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void method1() {
		// FileReader fr = new FileReader("src/com/shinhan/day11/printService.java");

		Class cls = ResourceTest.class;
		URL url = cls.getResource("PrintAnnotation.class");
		System.out.println(url.getPath());
	}

}
