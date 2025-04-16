package com.shinhan.day09.homework;

public class Account {

	int m;
	int balance;

	Account(int amount, int minus) {
		this.balance = amount;
		this.m = -minus;
	}

	public int solution(int[] ledger) {
		for (int request : ledger) {
			if (this.balance + request < m) {
				System.out.println(request + " 요청 거절, 잔고액 유지");
				continue;
			} else {
				this.balance += request;
				System.out.println(request + "요청 후 잔액: " + this.balance);
			}
		}
		return this.balance;
	}

}
