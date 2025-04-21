package com.shinhan.day13;

@FunctionalInterface
interface Function<T> {
	double apply(T r);
}

public class ch16_8 {
	private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

	public static void main(String[] args) {
		// avg(s -> s.getEnglishScore())는
		// Function<Student>의 apply 메서드를 람다로 구현해서 넘긴 것
		// (s -> s.getEnglishScore()) = Function<Student> 인터페이스를 구현한 익명 객체
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수: " + englishAvg);

		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}

	private static double avg(Function<Student> f) {
		double sum = 0;
		for (Student s : students) {
			sum += f.apply(s);
		}
		return (double) sum / students.length;
	}
}

class Student {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
}
