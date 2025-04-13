package com.shinhan.day09;

import java.io.IOException;

public class MyFileWriterExample {
	public static void main(String[] args) {
		try(MyFileWriter fw = new MyFileWriter("file.txt")) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}