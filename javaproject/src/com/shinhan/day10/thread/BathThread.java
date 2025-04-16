package com.shinhan.day10.thread;

public class BathThread extends Thread {
	BathRoom room;
	String name; //사용자

	public BathThread(String name, BathRoom room) {
		//super(name); // 스레드 이름 설정
		this.name = name;
		this.room = room;
	}

	@Override
	public void run() {
		//한 사람이 3번 사용
		for (int i = 0; i < 3; i++) {
			room.use(name);
		}

	}

}
