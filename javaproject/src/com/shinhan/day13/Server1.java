package com.shinhan.day13;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		// 1. 서버 소켓 생성 (포트 5000에서 클라이언트 연결을 대기함)
		ServerSocket serverSocket = new ServerSocket(5000);
		System.out.println("서버 준비 완료. 클라이언트 대기 중...");

		// 2. 클라이언트가 접속할 때까지 블로킹됨 (연결 오면 Socket 반환)
		Socket client = serverSocket.accept(); 
		//클라이언트의 IP 주소만 출력 (/127.0.0.1 형식)
		System.out.println("클라이언트 연결됨: " + client.getInetAddress());

		// 3. 클라이언트의 원격 접속 주소 정보 가져오기 
		//	IP + 포트 포함된 주소 객체 (InetSocketAddress)
		InetSocketAddress addr = (InetSocketAddress) client.getRemoteSocketAddress();

		// 4. 접속한 클라이언트의 IP 주소 출력
		System.out.println("접속 정보: " + addr.getAddress());
		// 필요하다면 client.getPort(), addr.getHostName() 등으로 포트/호스트 정보도 확인 가능

		// [주의] 데이터 송수신은 InputStream / OutputStream 으로 따로 구현해야 함
	}
}
