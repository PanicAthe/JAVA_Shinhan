package com.shinhan.day12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		problem8();
	}

	private static void problem8() {
		List<Member3> list = Arrays.asList(new Member3("홍길동", "개발자"), new Member3("김나리", "디자이너"),
				new Member3("신용권", "개발자"));

		Map<String, List<Member3>> groupingMap = list.stream().collect(Collectors.groupingBy(m -> m.getJob()));

		System.out.println("[개발자]");
		groupingMap.get("개발자").stream().forEach(m -> System.out.println(m));

		System.out.println();

		System.out.println("[디자이너]");
		groupingMap.get("디자이너").stream().forEach(m -> System.out.println(m));

	}

	private static void problem7() {
		List<Member2> list = Arrays.asList(new Member2("홍길동", "개발자"), new Member2("김나리", "디자이너"),
				new Member2("신용권", "개발자"));

		List<Member2> developers = list.stream().filter(m -> m.getJob().equals("개발자")).collect(Collectors.toList());

		developers.stream().forEach(m -> System.out.println(m.getName()));

	}

	private static void problem6() {
		List<Member> list = Arrays.asList(new Member("홍길동", 30), new Member("신용권", 40), new Member("감자바", 26));
		double avg = list.stream().mapToInt(m -> m.getAge()).average().getAsDouble();

		System.out.println("평균 나이: " + avg);

	}

	private static void problem5() {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream().filter(s -> s.toLowerCase().contains("java")).forEach(s -> System.out.println(s));
	}

}

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class Member2 {
	private String name;
	private String job;

	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
}

class Member3 {
	private String name;
	private String job;

	public Member3(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "{name:" + name + ", job:" + job + "}";
	}
}
