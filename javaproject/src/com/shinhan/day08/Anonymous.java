package com.shinhan.day08;

public class Anonymous {

	// 익명 클래스
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("익명구현class 구현하기(Field로 사용)");
		}
	};
	
	Vehicle field2 = ()->System.out.println("람다표현식으로 구현(Field로 사용)");

	void method1() {
		Vehicle localVar = ()->System.out.println("람다표현식으로 구현(메소드로 사용)");;
		localVar.run();
	}

	void method2(Vehicle v) {
		v.run();
	}
}