package com.shinhan.day09.lab;

public class CellPhone {
	String model;
	double battery;

	CellPhone(String model) {
		// 모델 번호를 인자로 받는 생성자
		this.model = model;
	}

	void call(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("통화시간입력오류");
		} else {
			System.out.println("통화 시간 : "+time);
			this.battery = Math.max(0, battery - time * 0.5);
		}
	}

	void charge(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("충전시간입력오류");
		} else {
			System.out.println("충전 시간 : "+time);
			this.battery = Math.min(100, battery + time * 3);
		}
	}
	// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
	// 충전되는 배터리 양 = 충전시간(분) * 3
	// 배터리 양은 100까지만 증가한다.
	// 충전 시간(분)이 0보다 작은 경우에는
	// IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.

	void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);// 남은 배터리 양을 출력한다.
	}

	public boolean equals(Object otherObject) {
		if (otherObject instanceof CellPhone c) {
			if (this.model.equals(c.model)) {
				return true;
			}
		}
		return false;
	}
	// Object 타입의 객체를 입력받고, 입력받은 객체가CellPhone 타입의 클래스이면서 모델 번호가 같은 경우에 true를 리턴한다.

}
