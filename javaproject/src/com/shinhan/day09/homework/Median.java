package com.shinhan.day09.homework;

import java.util.Arrays;

public class Median { //LAB3
	public static void main(String[] args) {
		Median median = new Median();
		int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
		System.out.println("input : " + Arrays.toString(values1));
		System.out.println("median : " + median.findMedian(values1));
		System.out.println("===============================");

		int[] values2 = { 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };
		System.out.println("input : " + Arrays.toString(values2));
		System.out.println("median : " + median.findMedian(values2));
	}

	public int findMedian(int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		int m = sum / values.length;

		int index = 0;
		Arrays.sort(values);
		for (int i = 1; i < values.length; i++) {
			if (Math.abs(values[i] - m) < Math.abs(values[index] - m)) {
				index = i;
			}
		}
		return values[index];

	}
}
