package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PrintThread extends Thread {
	ShareArea shareArea;

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
//			int a = shareArea.getSung().getBalance();
//			int b = shareArea.getLee().getBalance();
//			System.out.println("잔액 합계 " + (a + b));
			
			shareArea.print();
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
