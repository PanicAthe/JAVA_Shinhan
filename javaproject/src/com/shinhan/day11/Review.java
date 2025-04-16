package com.shinhan.day11;

class MyThread1 extends Thread{
	public void run() {
		System.out.println(currentThread().getName()+" 쓰레드");
	}
}

class MyThread2 implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName()+" 쓰레드");
	}
}

public class Review {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" 시작");
		
		MyThread1 t1 = new MyThread1();
		Runnable r1 = new MyThread2();
		Thread t2 = new Thread(r1);
		
		t1.start();
		t2.start();
		
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" 끝");

	}

}
