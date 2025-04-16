package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransferThread extends Thread {
	ShareArea shareArea;

	@Override
	public void run() {
		synchronized (shareArea) {
			for (int i = 0; i < 12; i++) {
				
				shareArea.transfer();
//				int amount1 = shareArea.getLee().withdraw(100);
//				System.out.println("출금 lee " + amount1);
//				int amount2 = shareArea.getSung().deposit(100);
//				System.out.println("입금 sung " + amount2);
//				System.out.println("=========================");

			}
		}
	}

}
