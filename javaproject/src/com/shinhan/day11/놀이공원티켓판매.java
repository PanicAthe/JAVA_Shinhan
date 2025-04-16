package com.shinhan.day11;

import java.util.Arrays;
import java.util.Comparator;

public class 놀이공원티켓판매 {

	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, { { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };

		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println(result);

			for (int[] arr : requests[testcast]) {
				System.out.println(Arrays.toString(arr));
			}

		}

	}

	private static int solution(int tickets, int[][] js) {

		Arrays.sort(js, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});

		int result = 0;
		for (int i = 0; i < js.length; i++) {
			if (tickets - js[i][1] - result >= 0) {
				result += js[i][1];
			}
		}
		return result;

	}
}