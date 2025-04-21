package com.shinhan.day13;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("192.168.0.238",5001);
		System.out.println("클라이언트가 서버에 연결 성공");
		//192.168.0.31
	}

}
