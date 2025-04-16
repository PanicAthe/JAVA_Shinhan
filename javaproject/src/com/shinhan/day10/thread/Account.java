package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
	private String accNo;
	private String owner;
	private int balance;

	public int withdraw(int amount) {
		if (this.balance < amount) {
			System.out.println("잔액 부족");
			return 0;
		}
		this.balance -= amount;
		return amount;
	}
	

	public int deposit(int amount) {

		this.balance += amount;
		return amount;
	}

}
