package com.shinhan.day12;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

interface AA{
//	void accept(Object o) {
//		만들어져 있음.
//	}
}


public class LambdaTest2 {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		//객체를 parameter 넘기고 이것을 사용.
		Consumer<String> a = (s)->{
			System.out.println(s);
		};
	}

}
