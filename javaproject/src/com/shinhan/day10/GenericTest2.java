package com.shinhan.day10;

import lombok.AllArgsConstructor;

class Person {
}

class Worker extends Person {
}

class Student extends Person {
}

class HighStudent extends Student {
}

class MiddleStudent extends Student {
}

@AllArgsConstructor
class Applicant<T> {
	public T kind;
}

class Course { // 와일드카드 타입 매개변수 연습
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
	}

	public static void registerCourse2(Applicant<? extends Student> student) {
		System.out.println(student.kind.getClass().getSimpleName() + "이(가) Course2을 등록함");
	}

	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함");
	}
}

public class GenericTest2 {

//1)타입매개변수 선언은 super는 사용불가
//<P extends Pair<K,V>,K,V>
//<T extends Number> //Number, Integer, Double......
//<T super Number> : 타입의 추론이 모호 Number, Object
	
//2)와일드가드 사용시(메서드매개변수, 변수선언)는 extends, super모두 가능
// Applicant<? extends Student>
// Applicant<? super Worker
	
//	static <P extends Pair<K, V>, K, V> V getValue2(P pair, K key) {
//
//		List<? super Number> alist = new ArrayList<>();
//		List<? extends Number> alist2 = new ArrayList<>();
//		List<?> alist3 = new ArrayList<>();
//
//		if (pair.getKey().equals(key)) {
//			return pair.getValue();
//		}
//
//		return null;
//	}

	public static void main(String[] args) {
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("==============");

		// Course.registerCourse2(new Applicant<Person>(new Person()));
		// Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("==============");

		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		// Course.registerCourse3(new Applicant<Student>(new Student()));
		// Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
		// Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("==============");
	}

}
