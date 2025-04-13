package com.shinhan.day08;

public class AnonymousTest2 {

	public static void main(String[] args) {
		// 구현 클래스 사용
		work(new RemoteA(), 10, 20);

		// 익명 구현
		work(new RemoteInterface() {
			@Override
			public String buttonsClick(int a, int b) {
				return "익명 구현" + a * b;
			}
		}, 20, 30);
		
		//람다
		RemoteInterface f = (aa,bb)->"람다 표현식 "+(aa/bb);
		work(f, 10, 3);
	}

	public static void work(RemoteInterface remote, int su1, int su2) {
		String result = remote.buttonsClick(su1, su2);
		System.out.println(result);
		System.out.println("==========================");
	}

}
