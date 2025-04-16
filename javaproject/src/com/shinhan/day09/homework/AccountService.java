package com.shinhan.day09.homework;

public class AccountService {

	public static void main(String[] args) {
		int[] input = { 10000, -13000, -4000, -2000, 6500, -20000 };

		Account acc = new Account(0, 5000);
		System.out.println("마지막 남은 잔고액: " + acc.solution(input));

		System.out.println("=====================");
		int[] input2 = { -34152, -40000, -50000 };
		Account acc2 = new Account(0,34151);
		System.out.println("마지막 남은 잔고액: " + acc2.solution(input2));

	}

}
