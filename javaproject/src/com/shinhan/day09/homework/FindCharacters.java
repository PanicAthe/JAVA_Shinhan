package com.shinhan.day09.homework;

public class FindCharacters { // LAB6, LAB8_문제2
	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		int count = fc.countChar("Boys, be ambitious", 'b');
		System.out.println(count);
	}

	public int countChar(String str, char c) {
		int count = 0;
		for (char temp : str.toCharArray()) {
			if (temp == c)
				count++;
		}
		return count;

	}
}
