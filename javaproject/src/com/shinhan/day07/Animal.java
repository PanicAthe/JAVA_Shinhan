package com.shinhan.day07;

public abstract class Animal {
	abstract void sound();

}

class Dog extends Animal {

	@Override
	void sound() {
		System.out.println("멍멍");

	}

}

class cat extends Animal {

	@Override
	void sound() {
		System.out.println("야옹");
	}

}