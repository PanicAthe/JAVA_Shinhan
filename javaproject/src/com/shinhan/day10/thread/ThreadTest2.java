package com.shinhan.day10.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		coll5();
	}

	private static void coll5() {
		WorkObject workObject = new WorkObject();
		
		ThreadA a = new ThreadA(workObject);
		ThreadB b = new ThreadB(workObject);
		
		a.start();
		b.start();
	}

	private static void coll4() {
		Calculator calculator = new Calculator();
		
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	}

	private static void coll3() {
		WorkThread workThreadA = new WorkThread("WorkThreadA");
		WorkThread workThreadB = new WorkThread("WorkThreadB");
		workThreadA.start();
		workThreadB.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workThreadA.work = false;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workThreadA.work = true;
		
	}

	private static void coll2() {
		BathRoom room = new BathRoom();
		BathThread t1 = new BathThread("탕", room);
		BathThread t2 = new BathThread("수", room);
		BathThread t3 = new BathThread("육", room);
		t1.start();
		t2.start();
		t3.start();
	}

	private static void coll() {
		Account sung = new Account("123,", "호랑이", 1000);
		Account lee = new Account("124,", "사자", 1000);
		ShareArea shareArea = new ShareArea(sung, lee);

		PrintThread t1 = new PrintThread(shareArea);
		TransferThread t2 = new TransferThread(shareArea);
		t1.start();
		t2.start();

	}

}
