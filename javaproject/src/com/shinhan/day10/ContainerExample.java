package com.shinhan.day10;

import lombok.Data;

class Container<T> {
	T name;

	public void set(T name) {
		this.name = name;
	}

	public T get() {
		return name;
	}
}

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
	}
}