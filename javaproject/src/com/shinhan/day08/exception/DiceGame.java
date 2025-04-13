package com.shinhan.day08.exception;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		try {
			if(n<0) {
				throw new IllegalArgumentException("던지는 횟수는 음수가 아니여야 합니다.");
			}
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		Dice dice = new Dice(8);
		Dice dice2 = new Dice(8);
		int count = 0;
		for (int i = 0; i < n; i++) {
			int a = dice.play();
			int b = dice2.play();
			if(a==b) {
				count++;
			}
		}
		return count;

	}
}
