package com.shinhan.day09;

public class StudentView {

	public static void print(StudentDTO[] arr) {
		for (StudentDTO s : arr) {
			System.out.println("=======view(all)=======");
			System.out.println(s);
		}
	}
	
	public static void print(StudentDTO st) {
		System.out.println("=======view(1건)=======");
		System.out.println(st);
	}

}
