package com.shinhan.day11.t;

public class ThreadExample {
	public static void main(String[] args) {
		Thread thread = new MovieThread3();
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		thread.interrupt(); // Thread에서 일시정지상태를 만듦 => sleep(1)
							// Exception처리함
	}
}

class MovieThread3 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다.");
			if(isInterrupted()) break;
		}
	}
}
