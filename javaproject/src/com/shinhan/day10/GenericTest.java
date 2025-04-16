package com.shinhan.day10;

import java.util.ArrayList;

public class GenericTest {

	public static <M extends Object, S, C> Bag makeBag(M model, S size, C color) {
		return new Bag<M, S, C>(model, size, color);
	}
	
	public static void useBag() {
		System.out.println(makeBag("모델", "사이즈", "컬러"));
		System.out.println(makeBag("모델", 100, "red"));
		System.out.println(makeBag("모델", 100, 255));
		
	}

	public static <A, B> Product makeProduct(A a, B b, int price) {
		Product<A, B> p1 = new Product<A, B>(a, b, price);
		Product<A, B> p2 = new Product<A, B>();
		return p1;
	}

	public static void main(String[] args) {
//		Product<String, String> result_product1 = makeProduct("문자", "str2", 2000);
//		System.out.println(result_product1);
//
//		Product<Integer, String> result_product2 = makeProduct(100, "str2", 2000);
//		System.out.println(result_product2);
		
		useBag();
	}

	private static void f4() {
		// TODO Auto-generated method stub

	}

	private static void f3() {
		ArrayList<Integer> data = new ArrayList();
		// data.add("LLM");
		data.add(100);

	}

	private static void f2() {
		ArrayList data = new ArrayList();
		data.add("LLM");
		data.add(100);

	}

	private static void f1() {
		Product<String, String> p1 = new Product<String, String>("Abc", "large", 1999);
		Product<String, Integer> p2 = new Product<String, Integer>("Abc", 3, 1999);

	}

}
