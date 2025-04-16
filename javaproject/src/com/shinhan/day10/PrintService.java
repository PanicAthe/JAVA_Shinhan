package com.shinhan.day10;

public class PrintService {
	
	@PrintAnnotation()
	public void mathod1() {
		System.out.println("실행 -- method1() ");
	}

	@PrintAnnotation(value = "아침 9시")
	public void mathod2() {
		System.out.println("실행 -- method2() ");
	}
	
	@PrintAnnotation(value = "고양이", number = 10)
	public void mathod3() {
		System.out.println("실행 -- method3() ");
	}
	
	@PrintAnnotation(value = "강아지", number2 = 3)
	public void mathod4() {
		System.out.println("실행 -- method4() ");
	}
}
