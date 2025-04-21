package ch19.sec03.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ClientHandler implements Runnable {

    private Socket socket;
    private Set<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String userName;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true); //true는 자동 flush
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            out.println("아이디를 입력하세요: ");
            userName = in.readLine();
            broadcast("[" + userName + "] 님이 입장하셨습니다.");

            String msg;
            while ((msg = in.readLine()) != null) {
                if (msg.equalsIgnoreCase("/bye")) break;
                broadcast("[" + userName + "]: " + msg);
            }
        } catch (IOException e) {
            System.out.println("클라이언트 연결 종료: " + socket.getInetAddress());
        } finally {
            try {
                clients.remove(this);
                broadcast("[" + userName + "] 님이 퇴장하셨습니다.");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String msg) {
        synchronized (clients) {
            for (ClientHandler ch : clients) {
                ch.out.println(msg);
            }
        }
    }
}
