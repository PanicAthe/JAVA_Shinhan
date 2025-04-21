package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
	public static void main(String[] args) throws Exception {

		// reverseLine("aa.txt", "bb.txt");
		addCalculateResult("cc.txt");
	}

	static void addCalculateResult(String inputFileName) throws Exception {
		List<Integer> numbers = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
			String s;
			while ((s = br.readLine()) != null) {
				numbers.add(Integer.parseInt(s));
			}
		}

		// 2. 계산
		int sum = 0;
		int mul = 1;
		for (int num : numbers) {
			sum += num;
			mul *= num;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName))) {
			for (int num : numbers) {
				bw.write(String.valueOf(num)); 
				bw.newLine();
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
			bw.write(String.valueOf(mul));
		}
	}

	static void reverseLine(String inputFileName, String outputFileName) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter output = new BufferedWriter(new FileWriter(outputFileName));

		List<String> str = new ArrayList<String>();

		String line;
		while ((line = input.readLine()) != null) {
			str.add(line);
		}

		while (!str.isEmpty()) {
			output.write(str.get(str.size() - 1));
			output.newLine();
			str.remove(str.size() - 1);
		}
		input.close();
		output.close();

	}
}
