package com.shinhan.day08;

class OuterClass {
	// 인스턴스 변수. 객체 생성 시 사용 가능
	int outerInstanceVar = 1;
	// 정적 변수, 객체 생성 안하고 사용 가능
	static int outerStaticVar = 2;

	void outerIstanceMethod() {
		System.out.println("outerInstanceVar " + outerInstanceVar);
		System.out.println("outerStaticVar " + outerStaticVar);
	}

	static void outerStaticMethod() {
		// System.out.println("outerInstanceVar "+outerInstanceVar);
		System.out.println("outerStaticVar " + outerStaticVar);
	}

	int score = 100;

	class InnerClass {
		int score = 200;
		// 인스턴스 변수. 객체 생성 시 사용 가능
		int innerInstanceVar = 3;
		// 정적 변수, 객체 생성 안하고 사용 가능
		static int innerStaticVar = 4;

		void innerIstanceMethod() {
			int score = 300;
			System.out.println("outerInstanceVar " + outerInstanceVar);
			System.out.println("outerStaticVar " + outerStaticVar);
			System.out.println("innerInstanceVar " + innerInstanceVar);
			System.out.println("innerStaticVar " + innerStaticVar);
			System.out.println("local score " + score);
			System.out.println("field score " + this.score);
			System.out.println("outer score " + OuterClass.this.score);
		}

		static void innerStaticMethod() {
			System.out.println("outerStaticVar " + outerStaticVar);
			// System.out.println("vInstanceVar "+innerInstanceVar);
			System.out.println("innerStaticVar " + innerStaticVar);
		}
	}

	static class StaticInnerClass {
		int score = 500;
		// 인스턴스 변수. 객체 생성 시 사용 가능
		int innerInstanceVar = 5;
		// 정적 변수, 객체 생성 안하고 사용 가능
		static int innerStaticVar = 6;

		void innerIstanceMethod() {
			int score = 600;
			// System.out.println("outerInstanceVar " + outerInstanceVar);
			System.out.println("outerStaticVar " + outerStaticVar);
			System.out.println("innerInstanceVar " + innerInstanceVar);
			System.out.println("innerStaticVar " + innerStaticVar);
			System.out.println("local score " + score);
			System.out.println("field score " + this.score);
			// System.out.println("outer score " + OuterClass.this.score);
		}

		static void innerStaticMethod() {
			System.out.println("outerStaticVar " + outerStaticVar);
			// System.out.println("vInstanceVar "+innerInstanceVar);
			System.out.println("innerStaticVar " + innerStaticVar);
		}
	}
}

public class InnerClassTest {

	public static void main(String[] args) {

		//f2();
		
		String address = "마포"; 
		
		class LocalClass {
			String name;
			static String name2 = "자바";

			LocalClass(String name) {
				this.name = name;
			}

			void f1() {
				System.out.println("local class name " + name + name2);
			}

			static void f2() {
				System.out.println("static class name " + name2);
			}
		}

	}

	private static void f2() {
		OuterClass.StaticInnerClass.innerStaticMethod();
	}

	private static void f1() {

		OuterClass.InnerClass v1 = new OuterClass().new InnerClass();
		v1.innerIstanceMethod();

		System.out.println(OuterClass.InnerClass.innerStaticVar);
		OuterClass.InnerClass.innerStaticMethod();

	}

}
