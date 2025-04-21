package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Vector;

import com.shinhan.day13.Score2.Score2Builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Score2{
	String name;
	int java;
	int db;
	int web;
}


public class IOTest {

	public static void main(String[] args) throws IOException {
		f9();
	}

	private static void f9() {
		File f1 = new File("aa.txt");
		System.out.println(f1.exists()? "파일 존재" : "파일 없음");
		
	}

	private static void f8() throws IOException {
		FileReader fr = new FileReader("data.txt");
		BufferedReader br = new BufferedReader(fr);

		Vector<Score2> scores = new Vector<Score2>();

		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] str = line.split("/");
			scores.add(new Score2.Score2Builder()
					.name(str[0])
					.java(Integer.parseInt(str[1]))
					.db(Integer.parseInt(str[2]))
					.web(Integer.parseInt(str[3]))
					.build());
		}
		
		System.out.println(scores.toString());

		br.close();
		fr.close();		
	}

	private static void f7() throws IOException {
		FileReader fr = new FileReader("data.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		System.out.println(line.replace("/", "\t") + "\t총점");

		while ((line = br.readLine()) != null) {
			String[] str = line.split("/");
			int sum = 0;
			for (int i = 1; i < str.length; i++) {
				sum += Integer.parseInt(str[i]);
			}
			System.out.println(line.replace("/", "\t") + "\t" + sum);

		}

		br.close();
		fr.close();
	}

	public void printScore(String fileName) {

	}

	private static void f6() throws IOException {
		FileWriter fw = new FileWriter("cc.txt");
		fw.write("문자 출력1\n");
		fw.write("문자 출력2\n");
		fw.write("문자 출력3\n");
		fw.close();

		FileReader fr = new FileReader("cc.txt");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.println((char) i);
		}
		fr.close();

	}

	private static void f5() throws IOException {
		FileOutputStream fos = new FileOutputStream("bb.txt");
		fos.write(97);
		fos.write(98);
		fos.write(99);
		fos.close();

		FileInputStream fis = new FileInputStream("bb.txt");
		int i;
		while ((i = fis.read()) != -1) {
			System.out.println((char) i);
		}

	}

	private static void f4() throws IOException {

		OutputStream os = System.out; // 상위 = 하위 (OutputStream <- PrintStream)
		os.write(97);
		os.flush();

		PrintStream ps = System.out;
		ps.println("문자열 출력함");
	}

	private static void f3() {
		try (FileReader fr = new FileReader("src/com/shinhan/day13/Example.java")) {
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} finally {
			System.out.println("작업END");
		}
	}

	// 파일과 콘솔 입력을 다루는 예제
	private static void f2() throws IOException {
		// Example.java 파일을 바이트 단위로 읽기 위한 FileInputStream 생성
		FileInputStream fi = new FileInputStream("src/com/shinhan/day13/Example.java");

		// 바이트 스트림을 문자 스트림으로 변환 (문자 인코딩 처리 가능)
		InputStreamReader ir = new InputStreamReader(fi);

		int i;
		// 파일의 끝(-1)까지 한 문자씩 읽어서 출력
		while ((i = ir.read()) != -1) {
			System.out.println((char) i); // 문자로 캐스팅하여 출력
		}

		// 스트림 자원 해제 (메모리 누수 방지)
		ir.close();
		fi.close();
	}

	private static void f1() throws IOException {
		System.out.print("입력>> ");

		// 표준 입력(System.in)은 InputStream 형태로, 바이트 단위로 입력 받음
		InputStream is = System.in;

		int i;
		byte[] arr = new byte[10]; // 최대 10바이트까지 입력 받을 버퍼 생성

		// 입력된 바이트를 배열에 저장, 반환값은 실제 읽은 바이트 수
		i = is.read(arr);

		// 읽은 바이트 수 출력
		System.out.println("크기: " + i);

		// 입력된 바이트 배열의 내용을 문자열이 아닌 숫자(바이트) 배열로 출력
		System.out.println(Arrays.toString(arr));
	}

}
