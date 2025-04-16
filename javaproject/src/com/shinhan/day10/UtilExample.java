package com.shinhan.day10;

class Util {

	Util() {
	}

	public static <K, V, P extends Pair<K, V>> V getValue(P pair, K key) {
		if (pair.getKey().equals(key)) {
			return pair.getValue();
		} else {
			return null;
		}
	}

}

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순");
		System.out.println(childAge);

		/*
		 * OtherPair<String, Integer> otherPair = new OtherPair< >("홍삼원", 20);
		 * OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생 int otherAge = Util.getValue(otherPair,
		 * "홍삼원"); System.out.println(otherAge);
		 */
	}
}
