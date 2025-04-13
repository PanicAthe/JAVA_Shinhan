package com.shinhan.day09;

public class Chatting {
	
	class Chat {
		void start() {
		}

		void sendMessage(String message) {
		}
	}

	void startChat(String chatId) {   
		String nickName = null;
		nickName = chatId;
		Chat chat = new Chat() {
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					//String message = "[" + nickName + "] " + inputData;
					//sendMessage(message);
					//Java에서 익명 클래스(또는 람다) 안에서 지역 변수를 참조할 경우
					//그 변수는 final 또는 사실상 final(effectively final)이어야 합니다.
				}
			}
		};
		chat.start();
	}
}