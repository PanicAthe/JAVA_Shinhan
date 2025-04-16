package com.shinhan.day10.thread;

//멀티thread 가능
public class LowerCaseThread extends Thread {

	@Override
	public void run() {

		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println("[" + currentThread().getName() + "]" + ch);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
