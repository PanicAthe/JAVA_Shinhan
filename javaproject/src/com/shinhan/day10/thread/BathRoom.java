package com.shinhan.day10.thread;

//공유 영역
public class BathRoom {

	boolean isFirst = true;

	public synchronized void use(String name) {
		if (isFirst && name.equals("탕")) {
			isFirst = false;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 입장 ");
		System.out.println(name + " 사용 ");
		System.out.println(name + " 퇴장 ");
		System.out.println("=================");
		
		notifyAll();
	}
}
