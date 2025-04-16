package com.shinhan.day10.thread;

//멀티thread 가능
public class UpperCaseThread extends Thread {

	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println("[" + currentThread().getName() + "]" + ch);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
