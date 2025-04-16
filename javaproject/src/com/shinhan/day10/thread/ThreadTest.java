package com.shinhan.day10.thread;

//thread - 프로세스 내의 실행 단위
//단일thread - 기본
//멀티thread
public class ThreadTest {

	public static void f1() {
		System.out.println("====대문자====");
	}

	public static void f2() {
		System.out.println("====소문자====");
	}

	public static void f3() {
		System.out.println("====숫자====");
	}

	public static void main(String[] args) {
		System.out.println("main 시작, thread 이름: " + Thread.currentThread().getName());
//		f1();
//		f2();
//		f3();

		UpperCaseThread t1 = new UpperCaseThread();
		LowerCaseThread t2 = new LowerCaseThread();
		NumberRunnable r1 = new NumberRunnable();
		Thread t3 = new Thread(r1);
		
		(new Thread() {
			@Override
			public void run() {
				for (int i = 1000; i < 1011; i++) {
					System.out.println("[" + currentThread().getName() + "]" + i);
				}

			}
		}).start();
		
		Thread t6 = new Thread(()->{for (int i = 2000; i < 2011; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + i);
		}});
		t6.start();
				
		t1.start();
		t2.start();
		t3.start();
		for (int i = 100; i < 127; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + i);
		}
		

		System.out.println("main끝");
	}

}
