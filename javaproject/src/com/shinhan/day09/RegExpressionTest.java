package com.shinhan.day09;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpressionTest {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		String regExp = "[가-힣]{3}"; // find()에는 ^, $ 없이 부분 매칭 패턴
		String data = " dd 김철수 박영희 sdfsf 이순신 ";

		HashSet<String> hs = new HashSet<>();
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(data);

		while (matcher.find()) {
			String name = matcher.group();
			System.out.println("추출됨: " + name);
			hs.add(name);
		}

		System.out.println("=== 최종 수집된 이름 목록 ===");
		for (String name : hs) {
			System.out.println(name);
		}

	}

	private static void f2() {
		String regExp = "[0-9A-Za-z]+@\\w+\\.[a-zA-Z]{2,}";
		String data = "wed0406@daum.net wed0406@naver.com  wed0406@gmail.com";

		HashSet<String> hs = new HashSet<String>();

		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.println(matcher.group());
			hs.add(matcher.group());
			System.out.println("====");
		}

//		boolean result = Pattern.matches(regExp, data);
//		System.out.println(result);
	}

	private static void f1() {
		// [] : 선택
		// - 범위
		// {3} 3자리수
		String regExp = "01[0-9]-[0-9]{3,4}-[0-9]{4}";
		String data = "aaaaaaaaaa 010-1234-5678   bbbbbb 011-123-9999";

		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
	}

}
