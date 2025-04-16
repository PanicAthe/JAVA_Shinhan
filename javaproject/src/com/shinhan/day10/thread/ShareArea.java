package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShareArea {
	private Account sung;
	private Account lee;

	public synchronized void print() {
		int a = sung.getBalance();
		int b = lee.getBalance();
		System.out.println("잔액 합계 " + (a + b));
	}

	public synchronized void transfer() {
		int amount = lee.withdraw(100);
		System.out.println("출금 lee " + amount);
		sung.deposit(amount);
		System.out.println("입금 sung " + amount);
		System.out.println("=========================");
	}

}
